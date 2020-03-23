package org.hanrw.spring.boot.autoconfiguration;

import org.hanrw.spring.boot.autoconfiguration.beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hanrw
 * @date 2020/3/23 1:46 PM
 */
@Configuration
public class MyConfiguration {
  @Bean
  public MyBean myBean() {
    MyBean myBean = new MyBean();
    myBean.setName("test");
    return myBean;
  }
}
