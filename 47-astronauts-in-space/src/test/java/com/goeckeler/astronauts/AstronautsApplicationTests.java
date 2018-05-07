package com.goeckeler.astronauts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@IfProfileValue(name = "junit.stage", values = {
  "integration",
  "system"
})
public class AstronautsApplicationTests
{
  @Test
  public void contextLoads() {
  }
}
