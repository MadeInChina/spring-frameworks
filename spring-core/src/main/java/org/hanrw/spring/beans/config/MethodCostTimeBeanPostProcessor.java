package org.hanrw.spring.beans.config;

import org.hanrw.spring.aop.cglib.CostTimeProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author hanrw
 * @date 2020/3/21 11:47 AM 实现自己的bpp,动态创建代理bean实例
 */
public class MethodCostTimeBeanPostProcessor implements BeanPostProcessor {

  /** bean初始化之后会调用的方法 */
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean.getClass().getName().contains("org.hanrw.spring.beans.config.service")) {
      return CostTimeProxy.createProxy(bean);
    } else {
      return bean;
    }
  }
}
