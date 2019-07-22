package org.metaborg.parsetable.symbols;

import static org.spoofax.terms.Term.*;

import org.metaborg.parsetable.ParseTableReadException;
import org.metaborg.parsetable.characterclasses.CharacterClassReader;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoList;

public class SymbolReader {

    private final CharacterClassReader characterClassReader;

    public SymbolReader(CharacterClassReader characterClassReader) {
        this.characterClassReader = characterClassReader;
    }

    public ISymbol read(IStrategoAppl symbolTerm) throws ParseTableReadException {
        IStrategoAppl symbolTermUnpacked = symbolTerm;
        SyntaxContext syntaxContext;

        if("varsym".equals(tryGetName(symbolTermUnpacked)))
            return readMetaVar(applAt(symbolTermUnpacked, 0));

        switch(tryGetName(symbolTermUnpacked)) {
            case "cf":
                symbolTermUnpacked = applAt(symbolTermUnpacked, 0);
                syntaxContext = SyntaxContext.ContextFree;
                break;
            case "lex":
                symbolTermUnpacked = applAt(symbolTermUnpacked, 0);
                syntaxContext = SyntaxContext.Lexical;
                break;
            default:
                syntaxContext = null;
                break;
        }

        SortCardinality cardinality;

        switch(tryGetName(symbolTermUnpacked)) {
            case "opt":
                symbolTermUnpacked = applAt(symbolTermUnpacked, 0);
                cardinality = SortCardinality.Optional;
                break;
            case "iter":
                symbolTermUnpacked = applAt(symbolTermUnpacked, 0);
                cardinality = SortCardinality.Iter;
                break;
            case "iter-sep":
                symbolTermUnpacked = applAt(symbolTermUnpacked, 0);
                cardinality = SortCardinality.IterSep;
                break;
            case "iter-star":
                symbolTermUnpacked = applAt(symbolTermUnpacked, 0);
                cardinality = SortCardinality.IterStar;
                break;
            case "iter-star-sep":
                symbolTermUnpacked = applAt(symbolTermUnpacked, 0);
                cardinality = SortCardinality.IterStarSep;
                break;
            case "iter-plus":
                symbolTermUnpacked = applAt(symbolTermUnpacked, 0);
                cardinality = SortCardinality.IterPlus;
                break;
            case "iter-plus-sep":
                symbolTermUnpacked = applAt(symbolTermUnpacked, 0);
                cardinality = SortCardinality.IterPlusSep;
                break;
            case "seq":
                return new SequenceSymbol(syntaxContext);
            default:
                cardinality = null;
                break;
        }

        switch(tryGetName(symbolTermUnpacked)) {
            case "sort":
            case "parameterized-sort":
            case "lit":
            case "cilit":
            case "layout":
                return readNonTerminal(symbolTermUnpacked, syntaxContext, cardinality);
            case "char-class":
                return readTerminal(symbolTermUnpacked, cardinality);
            case "alt":
                ISymbol first = read(termAt(symbolTermUnpacked, 0));
                ISymbol second = read(termAt(symbolTermUnpacked, 1));

                return new AltSymbol(syntaxContext, cardinality, first, second);
            default:
                throw new ParseTableReadException("invalid symbol term constructor: " + symbolTerm);
        }
    }

    private INonTerminalSymbol readNonTerminal(IStrategoAppl nonTerminalTerm, SyntaxContext syntaxContext,
        SortCardinality cardinality) throws ParseTableReadException {
        switch(tryGetName(nonTerminalTerm)) {
            case "sort":
                String sort = javaString(termAt(nonTerminalTerm, 0));
                return new SortSymbol(syntaxContext, cardinality, sort);
            case "parameterized-sort":
                String sortBase = javaString(termAt(nonTerminalTerm, 0));
                IStrategoList sortParametersTermList = termAt(nonTerminalTerm, 1);

                String[] sortParameters = new String[sortParametersTermList.size()];
                int index = 0;

                while(!sortParametersTermList.isEmpty()) {
                    sortParameters[index] = javaString(termAt(sortParametersTermList.head(), 0));
                    index++;
                    sortParametersTermList = sortParametersTermList.tail();
                }

                return new ParameterizedSortSymbol(syntaxContext, cardinality, sortBase, sortParameters);
            case "lit":
            case "cilit":
                String literal = javaString(termAt(nonTerminalTerm, 0));
                return new LiteralSymbol(syntaxContext, cardinality, literal);
            case "layout":
                return new LayoutSymbol(syntaxContext, cardinality);
            default:
                throw new ParseTableReadException("invalid nonterminal constructor: " + nonTerminalTerm);
        }
    }

    private ITerminalSymbol readTerminal(IStrategoAppl terminalTerm, SortCardinality cardinality) {
        IStrategoList characterClassTermList = termAt(terminalTerm, 0);
        ICharacterClass characterClass = characterClassReader.read(characterClassTermList);

        return new TerminalSymbol(characterClass, cardinality);
    }

    private IMetaVarSymbol readMetaVar(IStrategoAppl metaVarTerm) {
        // See old Stratego imploder for reference:
        // https://github.com/metaborg/strategoxt/blob/master/strategoxt/stratego-libraries/sglr/lib/stratego/asfix/implode/lexical.str

        if("cf".equals(tryGetName(metaVarTerm)))
            metaVarTerm = applAt(metaVarTerm, 0);

        MetaVarCardinality metaVarCardinality;

        switch(tryGetName(metaVarTerm)) {
            case "iter":
            case "iter-sep":
            case "iter-star":
            case "iter-star-sep":
            case "iter-plus":
            case "iter-plus-sep":
                metaVarCardinality = MetaVarCardinality.ListVar;
                break;
            default:
                metaVarCardinality = MetaVarCardinality.Var;
                break;
        }

        return new MetaVarSymbol(metaVarCardinality);
    }

}
