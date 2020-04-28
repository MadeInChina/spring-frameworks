package org.hanrw.spring.boot.core.conditional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hanrw
 * @date 2020/3/12 5:08 PM 怎么样启动一个Spring-boot项目
 */
@SpringBootApplication
public class OnConditionalApplication {
  public static void main(String[] args) {
    SpringApplication.run(OnConditionalApplication.class, args);
  }
}
