package org.hanrw.spring.beans.factory;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import org.hanrw.spring.beans.annotation.Query;
import org.hanrw.spring.services.QueryService;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author hanrw
 * @date 2020/4/2 10:36 AM
 */
public class QueryBeanFactory implements FactoryBean {
  private Class<?> classType;

  /**
   * 传入接口对象
   *
   * @param classType
   */
  public QueryBeanFactory(Class classType) {
    this.classType = classType;
  }

  @Override
  public QueryService getObject() throws Exception {
    QueryService queryService =
        (QueryService)
            Proxy.newProxyInstance(
                classType.getClassLoader(),
                new Class[] {QueryService.class},
                (proxy, method, args) -> {
                  System.out.println("被调用方法:" + method.getName() + "参数" + Arrays.asList(args));
                  Query query = method.getAnnotation(Query.class);
                  String sql = query.value();
                  System.out.println("执行sql:" + sql);
                  return sql;
                });
    return queryService;
  }

  @Override
  public Class<?> getObjectType() {
    return classType.getClass();
  }
}
