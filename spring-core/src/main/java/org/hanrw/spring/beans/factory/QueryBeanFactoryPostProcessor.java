package org.hanrw.spring.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author hanrw
 * @date 2020/4/2 10:27 AM
 * 用来动态修改具有@Query方法接口的bean定义信息
 */
//@Component
public class QueryBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    // 获取bean定义信息
    // TODO 遍历循环带有@Query方法的所有接口
    GenericBeanDefinition bd =
        (GenericBeanDefinition) beanFactory.getBeanDefinition("QueryService");
    Class clazz = bd.getBeanClass();
    // 因为接口不能被实例化,所以这里直接用工厂类来代替
    bd.setBeanClass(QueryBeanFactory.class);
    // 把接口的class对象传入QueryBeanFactory的构造方法
    ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
    constructorArgumentValues.addGenericArgumentValue(clazz);
    bd.setConstructorArgumentValues(constructorArgumentValues);
  }
}
