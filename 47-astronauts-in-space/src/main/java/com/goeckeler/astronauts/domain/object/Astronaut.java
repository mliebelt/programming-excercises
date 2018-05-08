package com.goeckeler.astronauts.domain.object;

import static org.apache.commons.lang3.StringUtils.defaultString;

import javax.persistence.*;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "astronauts")
public class Astronaut
  implements
  Comparable<Astronaut>
{
  @Id
  private int id;

  @Column(nullable = false, length = 80)
  private String name;

  @Column(nullable = false, length = 80)
  private String craft;

  public long getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getCraft() {
    return craft;
  }

  public void setCraft(final String craft) {
    this.craft = craft;
  }

  @Override
  public String toString() {
    return defaultString(getName());
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null) return false;
    if (this == other) return true;

    if (other instanceof Astronaut) {
      final Astronaut that = (Astronaut) other;

      boolean same = StringUtils.equals(this.getName(), that.getName());
      same &= StringUtils.equals(this.getCraft(), that.getCraft());

      return same;
    }

    return false;
  }

  @Override
  public int compareTo(final Astronaut that) {
    if (that == null) return 1;
    if (this == that) return 0;

    int cmp = StringUtils.compare(this.getCraft(), that.getCraft());
    if (cmp == 0) cmp = StringUtils.compare(this.getName(), that.getName());

    return cmp;
  }
}
