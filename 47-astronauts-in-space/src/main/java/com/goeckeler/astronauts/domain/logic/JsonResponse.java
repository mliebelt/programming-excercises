package com.goeckeler.astronauts.domain.logic;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResponse
{
  private List<JsonPeople> people;
  private int number;

  public List<JsonPeople> getPeople() {
    return people;
  }

  public void setPeople(final List<JsonPeople> people) {
    this.people = people;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(final int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "(" + number + ") : " + StringUtils.join(people, ", ");
  }
}
