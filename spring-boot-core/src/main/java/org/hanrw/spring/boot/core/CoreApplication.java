package org.hanrw.spring.boot.core;

import org.hanrw.spring.boot.autoconfiguration.beans.MyBean;
import org.hanrw.spring.boot.core.context.MyApplicationEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author hanrw
 * @date 2020/3/12 5:08 PM 怎么样启动一个Spring-boot项目
 */
@SpringBootApplication
public class CoreApplication {
  public static void main(String[] args) {
    ApplicationContext applicationContext = SpringApplication.run(CoreApplication.class, args);
    /*
     自动装配实现
    */
    MyBean myBean = (MyBean) applicationContext.getBean("myBean");
    System.out.println("=====Auto Configuration=====" + myBean.getName());
    /** 发送事件 */
    applicationContext.publishEvent(new MyApplicationEvent("=====MyApplicationEvent====="));
  }
}
