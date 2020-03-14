package org.hanrw.spring.boot.core.context;

import org.springframework.context.ApplicationEvent;

/**
 * @author hanrw
 * @date 2020/3/14 1:52 PM
 */
public class MyApplicationEvent extends ApplicationEvent {

  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with which the event is
   *     associated (never {@code null})
   */
  public MyApplicationEvent(String source) {
    super(source);
  }
}
