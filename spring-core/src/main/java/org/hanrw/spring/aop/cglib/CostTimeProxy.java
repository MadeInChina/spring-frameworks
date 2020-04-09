package org.hanrw.spring.aop.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author hanrw
 * @date 2020/3/21 11:37 AM 打印方法耗费时间代理类 实现cglib的MethodInterceptor
 */
public class CostTimeProxy implements MethodInterceptor {
  /*
  目标对象
   */
  private Object target;

  public CostTimeProxy(Object target) {
    this.target = target;
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    long starTime = System.nanoTime();
    /*
    调用代理对象
     */
    Object result = method.invoke(target, objects);
    long endTime = System.nanoTime();
    System.out.println(method + "，耗时(纳秒)：" + (endTime - starTime));
    return result;
  }

  /**
   * 创建代理类方法
   *
   * @param target
   * @param <T>
   * @return
   */
  public static <T> T createProxy(T target) {
    CostTimeProxy costTimeProxy = new CostTimeProxy(target);
    Enhancer enhancer = new Enhancer();
    enhancer.setCallback(costTimeProxy);
    enhancer.setSuperclass(target.getClass());
    return (T) enhancer.create();
  }
}
