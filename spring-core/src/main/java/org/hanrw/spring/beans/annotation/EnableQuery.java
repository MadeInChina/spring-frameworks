package org.hanrw.spring.beans.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.hanrw.spring.beans.config.MethodCostTimeImportSelector;
import org.hanrw.spring.beans.config.QueryImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

/**
 * @author hanrw
 * @date 2020/3/21 11:28 AM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(QueryImportBeanDefinitionRegistrar.class)
public @interface EnableQuery {}
