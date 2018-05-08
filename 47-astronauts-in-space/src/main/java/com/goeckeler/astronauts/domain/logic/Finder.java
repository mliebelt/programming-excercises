package com.goeckeler.astronauts.domain.logic;

import java.util.List;

import com.goeckeler.astronauts.domain.object.Astronaut;

public interface Finder
{
  public List<Astronaut> findAstronauts();
}
