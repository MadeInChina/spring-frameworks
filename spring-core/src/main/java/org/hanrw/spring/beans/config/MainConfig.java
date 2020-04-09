package org.hanrw.spring.beans.config;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hanrw.spring.beans.annotation.EnableMethodCostTime;
import org.hanrw.spring.beans.annotation.EnableQuery;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hanrw
 * @date 2020/3/21 11:51 AM
 */
@Configuration
@ComponentScan(value = "org.hanrw.spring")
@EnableAspectJAutoProxy
@EnableMethodCostTime
@EnableQuery
public class MainConfig {

  @Bean
  public AspectJExpressionPointcutAdvisor getAspectJExpressionPointcutAdvisor() {
    AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
    advisor.setExpression("execution(* org.hanrw.spring.services..*(..)))");
    advisor.setAdvice((MethodInterceptor) invocation -> {
      System.out.println("-->>前置通知");
      Object obj = invocation.proceed();
      System.out.println("-->>后置通知");
      return obj;
    });
    return advisor;
  }

}
