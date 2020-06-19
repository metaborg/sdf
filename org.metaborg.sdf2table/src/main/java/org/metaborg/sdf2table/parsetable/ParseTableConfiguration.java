package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;

public class ParseTableConfiguration implements Serializable {

    private static final long serialVersionUID = -7976937053924797179L;

    private final boolean dynamic;
    private final boolean dataDependent;
    private final boolean solveDeepConflicts;
    private final boolean checkOverlap;
    private final boolean checkPriorities;
    private final boolean layoutSensitive;

    public ParseTableConfiguration(boolean dynamic, boolean dataDependent, boolean solveDeepConflicts,
        boolean checkOverlap, boolean checkPriorities, boolean layoutSensitive) {
        this.dynamic = dynamic;
        this.dataDependent = dataDependent;
        this.solveDeepConflicts = solveDeepConflicts;
        this.checkOverlap = checkOverlap;
        this.checkPriorities = checkPriorities;
        this.layoutSensitive = layoutSensitive;
    }

    public boolean isDataDependent() {
        return dataDependent;
    }

    public boolean isSolveDeepConflicts() {
        return solveDeepConflicts;
    }

    public boolean isDynamic() {
        return dynamic;
    }

    public boolean isCheckOverlap() {
        return checkOverlap;
    }

    public boolean isCheckPriorities() {
        return checkPriorities;
    }

    public boolean isLayoutSensitive() {
        return layoutSensitive;
    }


}
