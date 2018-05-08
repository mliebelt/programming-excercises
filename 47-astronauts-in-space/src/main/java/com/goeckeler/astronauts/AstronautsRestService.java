package com.goeckeler.astronauts;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goeckeler.astronauts.domain.logic.AstronautsService;
import com.goeckeler.astronauts.domain.model.AstronautsInSpace;

@RestController
@RequestMapping(value = "/rest")
@Transactional(readOnly = true)
public class AstronautsRestService
{
  @Autowired
  private AstronautsService astronautsService;

  @RequestMapping(method = GET, value = "/astronauts")
  public AstronautsInSpace reportAstronautsInSpace() {
    return astronautsService.reportAstronautsInSpace();
  }
}
