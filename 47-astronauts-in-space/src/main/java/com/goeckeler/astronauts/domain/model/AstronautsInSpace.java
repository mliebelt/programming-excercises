package com.goeckeler.astronauts.domain.model;

import java.util.*;

import org.apache.commons.collections4.CollectionUtils;

import com.goeckeler.astronauts.domain.object.Astronaut;

public class AstronautsInSpace
{
  private Set<CraftsInSpace> crafts;
  private int population;

  public AstronautsInSpace(final List<Astronaut> astronauts) {
    this.population = CollectionUtils.size(astronauts);
    if (population > 0) {
      final Map<String, Set<String>> flights = new HashMap<>(97);

      for (final Astronaut astronaut : astronauts) {
        Set<String> humans = flights.get(astronaut.getCraft());
        if (humans == null) {
          humans = new TreeSet<>();
          flights.put(astronaut.getCraft(), humans);
        }
        humans.add(astronaut.getName());
      }

      crafts = new TreeSet<>();
      for (final Map.Entry<String, Set<String>> flight : flights.entrySet()) {
        crafts.add(new CraftsInSpace(flight.getKey(), flight.getValue()));
      }
    } else {
      crafts = Collections.emptySet();
    }
  }

  public Set<CraftsInSpace> getCrafts() {
    return crafts;
  }

  public int getPopulation() {
    return population;
  }
}
