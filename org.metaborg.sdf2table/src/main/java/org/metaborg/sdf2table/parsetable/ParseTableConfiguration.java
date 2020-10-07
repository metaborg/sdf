package org.metaborg.sdf2table.parsetable;

import java.io.Serializable;
import java.util.Objects;

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

    
    @Override public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        final ParseTableConfiguration that = (ParseTableConfiguration)o;
        return dynamic == that.dynamic &&
            dataDependent == that.dataDependent &&
            solveDeepConflicts == that.solveDeepConflicts &&
            checkOverlap == that.checkOverlap &&
            checkPriorities == that.checkPriorities &&
            layoutSensitive == that.layoutSensitive;
    }

    @Override public int hashCode() {
        return Objects.hash(dynamic, dataDependent, solveDeepConflicts, checkOverlap, checkPriorities, layoutSensitive);
    }
}
