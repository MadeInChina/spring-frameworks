package org.hanrw.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author hanrw
 * @date 2020/4/2 5:20 PM
 */
@Aspect
@Component
public class TransactionalAspect {
  @Pointcut("execution(* org.hanrw.spring.service..*(..))")
  public void pointCut(){};
  /**
   * 前置通知
   *
   * @param joinPoint
   */
  @Before("pointCut()")
  public void before(JoinPoint joinPoint) {
    System.out.println("-->>前置通知");
  }

  /**
   * 后置通知
   *
   * @param joinPoint
   */
  @After("pointCut()")
  public void after(JoinPoint joinPoint) {
    System.out.println("-->>后置通知");
  }

  /**
   * 返回通知
   *
   * @param joinPoint
   * @param result
   */
  @AfterReturning(value = "pointCut()", returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result) {
    System.out.println("-->>返回通知");
  }

  @AfterThrowing(value = "pointCut()", throwing = "exception")
  public void afterThrowing(JoinPoint joinPoint, Exception exception) {
    System.out.println("-->>异常通知");
  }
}
