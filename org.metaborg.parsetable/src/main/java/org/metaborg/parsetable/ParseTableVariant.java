package org.metaborg.parsetable;

import java.util.Objects;

import org.metaborg.parsetable.query.ActionsForCharacterRepresentation;
import org.metaborg.parsetable.query.ProductionToGotoRepresentation;
import org.metaborg.parsetable.states.IStateFactory;
import org.metaborg.parsetable.states.StateFactory;

public class ParseTableVariant {
    public final ActionsForCharacterRepresentation actionsForCharacterRepresentation;
    public final ProductionToGotoRepresentation productionToGotoRepresentation;

    public ParseTableVariant(ActionsForCharacterRepresentation actionsForCharacterRepresentation,
        ProductionToGotoRepresentation productionToGotoRepresentation) {
        this.actionsForCharacterRepresentation = actionsForCharacterRepresentation;
        this.productionToGotoRepresentation = productionToGotoRepresentation;
    }

    /** Uses the standard ActionsForCharacterRepresentation and ProductionToGotoRepresentation. */
    public ParseTableVariant() {
        this(ActionsForCharacterRepresentation.standard(), ProductionToGotoRepresentation.standard());
    }

    public static ParseTableVariant standard() {
        return new ParseTableVariant();
    }

    public String name() {
        return (actionsForCharacterRepresentation == ActionsForCharacterRepresentation.standard() ? "_"
            : "ActionsForCharacterRepresentation:" + actionsForCharacterRepresentation) + "/"
            + (productionToGotoRepresentation == ProductionToGotoRepresentation.standard() ? "_"
                : "ProductionToGotoRepresentation:" + productionToGotoRepresentation);
    }

    public ParseTableReader parseTableReader() {
        IStateFactory stateFactory =
            new StateFactory(actionsForCharacterRepresentation, productionToGotoRepresentation);

        return new ParseTableReader(stateFactory);
    }

    @Override public int hashCode() {
        return Objects.hash(actionsForCharacterRepresentation, productionToGotoRepresentation);
    }

    @Override public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        ParseTableVariant that = (ParseTableVariant) o;

        return actionsForCharacterRepresentation == that.actionsForCharacterRepresentation
            && productionToGotoRepresentation == that.productionToGotoRepresentation;
    }
}
