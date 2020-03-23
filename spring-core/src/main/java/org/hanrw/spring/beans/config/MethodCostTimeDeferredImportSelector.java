package org.hanrw.spring.beans.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hanrw
 * @date 2020/3/21 11:49 AM
 *     DeferredImportSelector实例的selectImports方法的执行时机，是在@Configguration注解中的其他逻辑被处理**完毕之后**
 *     具体位置在ConfigurationClassParser.processImports
 */
public class MethodCostTimeDeferredImportSelector implements DeferredImportSelector {
  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[] {MethodCostTimeBeanPostProcessor.class.getName()};
  }
}
