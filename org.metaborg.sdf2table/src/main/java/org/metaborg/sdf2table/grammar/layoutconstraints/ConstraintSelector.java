package org.metaborg.sdf2table.grammar.layoutconstraints;

public enum ConstraintSelector {
    FIRST {
        @Override public String toString() {
            return "first";
        }
    },
    LEFT {
        @Override public String toString() {
            return "left";
        }
    },
    RIGHT {
        @Override public String toString() {
            return "right";
        }
    },
    LAST {
        @Override public String toString() {
            return "last";
        }
    }
}
