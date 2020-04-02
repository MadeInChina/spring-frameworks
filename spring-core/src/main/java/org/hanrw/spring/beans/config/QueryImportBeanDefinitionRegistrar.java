package org.hanrw.spring.beans.config;

import java.util.Set;
import org.hanrw.spring.beans.annotation.Query;
import org.hanrw.spring.beans.factory.QueryBeanFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

/**
 * @author hanrw
 * @date 2020/4/2 11:26 AM
 */
public class QueryImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

  @Override
  public void registerBeanDefinitions(
      AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
    // 获取scanner
    ClassPathScanningCandidateComponentProvider scanner = getScanner();
    scanner.addIncludeFilter(new AnnotationTypeFilter(Component.class));

    Set<BeanDefinition> definitionSet =
        scanner.findCandidateComponents("org.hanrw.spring.services");
    // TODO 遍历循环带有@Query方法的所有接口
    definitionSet.forEach(
        beanDefinition -> {
          if (beanDefinition.getBeanClassName().contains("QueryService")) {
            GenericBeanDefinition bd = (GenericBeanDefinition) beanDefinition;
            // 这个时候还没有beanClass对象, 所以不能用bd.getBeanClass()获取beanClass
            // java.lang.IllegalStateException: Bean class name
            // [org.hanrw.spring.services.QueryService] has not been resolved into an actual Class
            // Class clazz = bd.getBeanClass();

            // 先获取到bean类名
            String className = bd.getBeanClassName();
            // 新建一个bean定义
            BeanDefinitionBuilder builder = BeanDefinitionBuilder
                                                .genericBeanDefinition(QueryBeanFactory.class);
            // 把接口的class对象传入QueryBeanFactory的构造方法
            builder.addConstructorArgValue(className);
            //注入容器中
            registry.registerBeanDefinition(
                className ,
                builder.getBeanDefinition());
          }
        });
  }

  /**
   * 默认的ClassPathScanningCandidateComponentProvider是不会去扫描接口类的 所以这里我们需要重写改方法来支持扫描接口
   *
   * @return
   */
  protected ClassPathScanningCandidateComponentProvider getScanner() {
    return new ClassPathScanningCandidateComponentProvider(false) {
      @Override
      protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        return (beanDefinition.getMetadata().isInterface()
            || (metadata.isIndependent() && (metadata.isConcrete())
                || (metadata.isAbstract()
                    && metadata.hasAnnotatedMethods(Lookup.class.getName()))));
      }
    };
  }
}
