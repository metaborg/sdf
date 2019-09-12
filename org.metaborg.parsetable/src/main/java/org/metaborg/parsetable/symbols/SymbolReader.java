package org.metaborg.parsetable.symbols;

import static org.spoofax.terms.Term.*;

import java.util.ArrayList;
import java.util.List;

import org.metaborg.parsetable.ParseTableReadException;
import org.metaborg.parsetable.characterclasses.CharacterClassReader;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class SymbolReader {

    private final CharacterClassReader characterClassReader;

    public SymbolReader(CharacterClassReader characterClassReader) {
        this.characterClassReader = characterClassReader;
    }

    public ISymbol read(IStrategoAppl symbolTerm) throws ParseTableReadException {
        IStrategoAppl symbolTermUnpacked = symbolTerm;

        if("varsym".equals(tryGetName(symbolTermUnpacked)))
            return readMetaVar(applAt(symbolTermUnpacked, 0));

        // Checks if the sort is wrapped in `cf()` or `lex()`
        SyntaxContext syntaxContext = getSyntaxContext(symbolTermUnpacked);
        if(syntaxContext != null)
            symbolTermUnpacked = applAt(symbolTermUnpacked, 0); // If the term was indeed wrapped, unpack it

        // Checks if the sort is wrapped in `opt()` or any `iter...()`
        SortCardinality cardinality = getSortCardinality(symbolTermUnpacked);
        if(cardinality != null)
            symbolTermUnpacked = applAt(symbolTermUnpacked, 0);

        // Because the order of the context and cardinality is not fixed, check for the context again
        // E.g. both cf(iter(...)) and iter(cf(...)) are possible representations of sorts in the parse table term
        if(syntaxContext == null) {
            syntaxContext = getSyntaxContext(symbolTermUnpacked);
            if(syntaxContext != null)
                symbolTermUnpacked = applAt(symbolTermUnpacked, 0);
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
            case "seq":
                List<ISymbol> symbols = new ArrayList<>();

                // See org.metaborg.sdf2table.grammar.SequenceSymbol for the representation of a seq in the parse table
                if(symbolTermUnpacked.getSubtermCount() == 2) {
                    symbols.add(read(termAt(symbolTermUnpacked, 0)));
                    for(IStrategoTerm tailTerm : termAt(symbolTermUnpacked, 1)) {
                        symbols.add(read((IStrategoAppl) tailTerm));
                    }
                }
                // Apparently there is also an other representation of seq where there is just a list, no separate head
                // Used in e.g. the parse table of GreenMarl in the integration tests of JSGLR2
                else if(symbolTermUnpacked.getSubtermCount() == 1) {
                    for(IStrategoTerm tailTerm : termAt(symbolTermUnpacked, 0)) {
                        symbols.add(read((IStrategoAppl) tailTerm));
                    }
                } else
                    throw new ParseTableReadException("invalid sequence term constructor: " + symbolTerm);

                return new SequenceSymbol(syntaxContext, cardinality, symbols);
            default:
                throw new ParseTableReadException("invalid symbol term constructor: " + symbolTerm);
        }
    }

    private SyntaxContext getSyntaxContext(IStrategoAppl symbolTermUnpacked) {
        switch(tryGetName(symbolTermUnpacked)) {
            case "cf":
                return SyntaxContext.ContextFree;
            case "lex":
                return SyntaxContext.Lexical;
            default:
                return null;
        }
    }

    private SortCardinality getSortCardinality(IStrategoAppl symbolTermUnpacked) {
        switch(tryGetName(symbolTermUnpacked)) {
            case "opt":
                return SortCardinality.Optional;
            case "iter":
                return SortCardinality.Iter;
            case "iter-sep":
                return SortCardinality.IterSep;
            case "iter-star":
                return SortCardinality.IterStar;
            case "iter-star-sep":
                return SortCardinality.IterStarSep;
            case "iter-plus":
                return SortCardinality.IterPlus;
            case "iter-plus-sep":
                return SortCardinality.IterPlusSep;
            default:
                return null;
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
