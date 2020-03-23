package org.hanrw.spring.boot.core.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hanrw
 * @date 2020/3/14 1:06 PM 配置方式三种 1.SpringApplication app = new SpringApplication(); *
 *     app.addInitializers(new MyApplicationContextInitializer()); 2.在application.yml文件中设置
 *     ，可以指定多个，用逗号分隔即可 DelegatingApplicationContextInitializer 根据 PROPERTY_NAME =
 *     "context.initializer.classes" context.initializer.class =
 *     com.wyf.springboot.extend.MyApplicationContextInitializer(类路径)
 *     3.在META-INF/spring.factories文件中配置 SpringFactoriesLoader META-INF/spring.factories
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
    System.out.println(
        "===========bean count================" + applicationContext.getBeanDefinitionCount());
  }
}
