package org.hanrw.spring.boot.core.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hanrw
 * @date 2020/4/28 3:39 PM
 */
@Configuration
public class OnConditionalConfig {


  @Bean
  public City city() {
    City city = new City();
    city.setCityName("千岛湖");
    return city;
  }

  @Bean
  @ConditionalOnBean(name = "city")
  public People people(City city) {
    city.setCityCode(301701);
    return new People("小小", 3, city);
  }
}
