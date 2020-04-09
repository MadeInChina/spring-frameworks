package org.hanrw.spring.service;

import org.hanrw.spring.beans.config.MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hanrw
 * @date 2020/3/21 11:52 AM
 */
public class UserServiceTest {
  @Test
  public void testQueryService() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(MainConfig.class);
    UserService userService = context.getBean(UserService.class);
    userService.updateUser();
  }
}
