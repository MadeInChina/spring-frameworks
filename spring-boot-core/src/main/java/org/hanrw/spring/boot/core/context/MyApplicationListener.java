package org.hanrw.spring.boot.core.context;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author hanrw
 * @date 2020/3/14 1:39 PM
 * ApplicationStartingEvent
 * ApplicationEnvironmentPreparedEvent
 * ApplicationContextInitializedEvent
 * ApplicationPreparedEvent
 * ContextRefreshedEvent
 * ServletWebServerInitializedEvent
 * ApplicationStartedEvent
 * ApplicationReadyEvent
 * 通过applicationContext.publishEvent调用ApplicationEventMulticaster发送事件
 */
public class MyApplicationListener implements ApplicationListener {

  @Override
  public void onApplicationEvent(ApplicationEvent event) {
    System.out.println("===========ApplicationEvent================" + event.getClass().getSimpleName());
  }
}
