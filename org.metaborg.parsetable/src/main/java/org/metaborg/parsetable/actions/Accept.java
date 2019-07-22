package org.metaborg.parsetable.actions;

public class Accept implements IAccept {

    public static final Accept SINGLETON = new Accept();

    public Accept() {
    }

    @Override public String toString() {
        return "accept()";
    }

    @Override public int hashCode() {
        return 0;
    }

    @Override public boolean equals(Object o) {
        return this == o || (o != null && getClass() != o.getClass());
    }

}
