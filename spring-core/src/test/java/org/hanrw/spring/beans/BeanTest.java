package org.hanrw.spring.beans;

import org.hanrw.spring.beans.config.EnableMethodCostTimeConfig;
import org.hanrw.spring.beans.config.ServiceA;
import org.hanrw.spring.beans.config.ServiceB;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hanrw
 * @date 2020/3/21 11:52 AM
 */
public class BeanTest {
  @Test
  public void testEnableMethodCostTimeConfig() {
    // 1.通过AnnotationConfigApplicationContext创建spring容器，参数为@Import标注的类
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(EnableMethodCostTimeConfig.class);
    ServiceA service1 = context.getBean(ServiceA.class);
    ServiceB service2 = context.getBean(ServiceB.class);
    service1.say();
    service2.say();
  }
}
