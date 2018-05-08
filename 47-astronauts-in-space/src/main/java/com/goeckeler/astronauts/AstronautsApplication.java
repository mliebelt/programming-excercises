package com.goeckeler.astronauts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AstronautsApplication
{

  public static void main(final String[] args) {
    SpringApplication.run(AstronautsApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplateBuilder().build();
  }
}
