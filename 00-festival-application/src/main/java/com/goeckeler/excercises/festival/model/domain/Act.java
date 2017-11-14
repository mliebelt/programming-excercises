package com.goeckeler.excercises.festival.model.domain;

import org.apache.commons.lang3.StringUtils;

public class Act implements Named, Comparable<Act> {
    private final String name;

    public Act(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return toString();
    }


    @Override
    public boolean equals(final Object other) {
        if (other == null) return false;
        if (this == other) return true;

        // For complex tests check if object is actually of the same type!
        //
        // variant a) <code>if (this.getClass() != other.getClass()) return false;</code>
        // variant b) <code>if (!(other instanceof Act)) return false;<code>
        //
        // Then cast the other object <code>Act that = (Act) other;<code>.
        // However, variant a) works only on object of the identical class, aka no subtypes.
        //  ... and variant b) requires "final" on equals, otherwise reflexivity is broken.
        //
        // There is actually variant c). Use an interface like <code>Named</code> and only
        // use the attributes of that interface, then you can use <code>instanceof Interface</code> w/o final.

        return other instanceof Named && this.toString().equals(other.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public int compareTo(Act that) {
        if (that == null) return 1;
        return this.toString().compareTo(that.toString());
    }

    @Override
    public String toString() {
        return StringUtils.defaultIfBlank(name, "Unknown");
    }
}
