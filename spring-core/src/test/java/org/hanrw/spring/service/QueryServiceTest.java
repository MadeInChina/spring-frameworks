package org.hanrw.spring.service;

import org.hanrw.spring.beans.config.MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hanrw
 * @date 2020/3/21 11:52 AM
 */
public class QueryServiceTest {
  @Test
  public void testQueryService() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(MainConfig.class);
    QueryService queryService = (QueryService) context.getBean("org.hanrw.spring.services.QueryService");
    queryService.query("test");
  }
}
