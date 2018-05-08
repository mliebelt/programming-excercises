package com.goeckeler.astronauts.domain.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.goeckeler.astronauts.domain.dao.AstronautRepository;
import com.goeckeler.astronauts.domain.object.Astronaut;

@Component
@Transactional(readOnly = true)
public class DatabaseFinder
  implements
  Finder
{
  @Autowired
  private AstronautRepository dao;

  @Override
  public List<Astronaut> findAstronauts() {
    return dao.findAll();
  }
}
