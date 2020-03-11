package org.metaborg.parsetable;

import java.io.IOException;
import java.io.InputStream;

import org.metaborg.parsetable.actions.ActionsFactory;
import org.metaborg.parsetable.actions.IActionsFactory;
import org.metaborg.parsetable.characterclasses.CharacterClassFactory;
import org.metaborg.parsetable.characterclasses.CharacterClassReader;
import org.metaborg.parsetable.characterclasses.ICharacterClassFactory;
import org.metaborg.parsetable.productions.ProductionReader;
import org.metaborg.parsetable.states.IStateFactory;
import org.metaborg.parsetable.states.StateFactory;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.TermFactory;
import org.spoofax.terms.io.binary.TermReader;
import org.spoofax.terms.util.TermUtils;

public class ParseTableReader {

    private final ParseTableReaderDelegate v6Delegate;
    private final ParseTableReaderDelegate v7Delegate;

    public ParseTableReader() {
        this(new CharacterClassFactory(), new ActionsFactory(), new StateFactory());
    }

    public ParseTableReader(IStateFactory stateFactory) {
        this(new CharacterClassFactory(), new ActionsFactory(), stateFactory);
    }

    public ParseTableReader(ICharacterClassFactory characterClassFactory, IActionsFactory actionsFactory,
        IStateFactory stateFactory) {
        CharacterClassReader characterClassReaderV6 = new CharacterClassReader(characterClassFactory);
        v6Delegate = new ParseTableReaderDelegate(actionsFactory, stateFactory, characterClassReaderV6,
            new ProductionReader(characterClassReaderV6));

        CharacterClassReader characterClassReaderV7 = new CharacterClassReader.V7(characterClassFactory);
        v7Delegate = new ParseTableReaderDelegate(actionsFactory, stateFactory, characterClassReaderV7,
            new ProductionReader(characterClassReaderV7));
    }

    public IParseTable read(IStrategoTerm pt) throws ParseTableReadException {
        int version = TermUtils.toJavaIntAt(pt, 0);
        if(version <= 6)
            return v6Delegate.read(pt);
        else if(version == 7)
            return v7Delegate.read(pt);
        else
            throw new IllegalStateException("Unsupported parse table version: " + version);
    }

    public IParseTable read(InputStream inputStream) throws ParseTableReadException, IOException {
        TermReader termReader = new TermReader(new TermFactory());

        IStrategoTerm parseTableTerm = termReader.parseFromStream(inputStream);

        return read(parseTableTerm);
    }

}
