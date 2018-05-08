package com.goeckeler.astronauts.domain.logic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goeckeler.astronauts.domain.model.AstronautsInSpace;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AstronautsService
{
  private static Log LOG = LogFactory.getLog(AstronautsService.class);

  @Autowired
  private RestFinder restFinder;

  @Autowired
  private DatabaseFinder databaseFinder;

  @HystrixCommand(fallbackMethod = "reportAstronautsInSpaceFromCache")
  public AstronautsInSpace reportAstronautsInSpace() {
    LOG.debug("Finding astronauts in the world wide web.");
    return new AstronautsInSpace(restFinder.findAstronauts());
  }

  public AstronautsInSpace reportAstronautsInSpaceFromCache() {
    LOG.warn("Finding astronauts from the local database.");
    return new AstronautsInSpace(databaseFinder.findAstronauts());
  }
}
