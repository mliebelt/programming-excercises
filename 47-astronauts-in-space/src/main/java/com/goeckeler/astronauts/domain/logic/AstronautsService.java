package com.goeckeler.astronauts.domain.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goeckeler.astronauts.domain.model.AstronautsInSpace;

@Service
public class AstronautsService
{
  @Autowired
  private RestFinder restFinder;

  public AstronautsInSpace reportAstronautsInSpace() {
    return new AstronautsInSpace(restFinder.findAstronauts());
  }
}
