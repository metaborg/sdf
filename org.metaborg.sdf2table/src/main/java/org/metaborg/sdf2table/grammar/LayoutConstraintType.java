package org.metaborg.sdf2table.grammar;

public enum LayoutConstraintType {
    Line {
        @Override public String toString() {
            return "l";
        }
    }, Column {
        @Override public String toString() {
            return "c";
        }
    }, EndLine {
        @Override public String toString() {
            return "el";
        }
    }, EndColumn {
        @Override public String toString() {
            return "ec";
        }
    }
}
