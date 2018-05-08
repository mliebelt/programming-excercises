package com.goeckeler.astronauts.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goeckeler.astronauts.domain.object.Astronaut;

public interface AstronautRepository
  extends
  JpaRepository<Astronaut, Integer>
{

}
