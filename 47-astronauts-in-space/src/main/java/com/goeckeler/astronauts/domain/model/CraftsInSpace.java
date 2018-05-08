package com.goeckeler.astronauts.domain.model;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class CraftsInSpace
  implements
  Comparable<CraftsInSpace>
{
  private String craft;
  private Set<String> astronauts;

  public CraftsInSpace(final String craft, final Set<String> astronauts) {
    this.craft = craft;
    this.astronauts = astronauts;
  }

  public String getCraft() {
    return craft;
  }

  public Set<String> getAstronauts() {
    return astronauts;
  }

  @Override
  public String toString() {
    return StringUtils.defaultString(craft);
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) return true;
    if (other == null) return false;

    if (other instanceof CraftsInSpace) { return StringUtils.equals(this.toString(), other.toString()); }

    return false;
  }

  @Override
  public int compareTo(final CraftsInSpace that) {
    return StringUtils.compare(this.toString(), that.toString());
  }
}
