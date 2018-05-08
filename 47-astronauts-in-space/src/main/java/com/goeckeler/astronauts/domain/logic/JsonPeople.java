package com.goeckeler.astronauts.domain.logic;

import static org.apache.commons.lang3.StringUtils.defaultIfEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPeople
{
  private String name;
  private String craft;

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
    return defaultIfEmpty(name, "No Name") + "@" + defaultIfEmpty(craft, "Orbiter");
  }
}
