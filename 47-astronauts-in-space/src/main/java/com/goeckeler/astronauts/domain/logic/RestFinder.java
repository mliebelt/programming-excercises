package com.goeckeler.astronauts.domain.logic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.goeckeler.astronauts.domain.object.Astronaut;

@Component
public class RestFinder
  implements
  Finder
{

  private final RestTemplate restTemplate;
  private final String astronautsInSpaceUrl;

  @Autowired
  public RestFinder(final RestTemplate restTemplate,
                    @Value("${rest.astronauts.url}") final String astronautsInSpaceUrl)
  {
    this.restTemplate = restTemplate;
    this.astronautsInSpaceUrl = astronautsInSpaceUrl;
  }

  @Override
  public List<Astronaut> findAstronauts() {
    final Optional<JsonResponse> response =
        Optional.ofNullable(restTemplate.getForObject(astronautsInSpaceUrl, JsonResponse.class));

    final List<Astronaut> astronauts = new ArrayList<>(53);
    if (response.isPresent()) {
      for (final JsonPeople people : response.get().getPeople()) {
        final Astronaut astronaut = new Astronaut();
        astronaut.setCraft(people.getCraft());
        astronaut.setName(people.getName());
        astronauts.add(astronaut);
      }
    }
    return astronauts;
  }
}
