package org.hanrw.spring.beans.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
/**
 * @author hanrw
 * @date 2020/3/21 11:49 AM
 *     ImportSelector实例的selectImports方法的执行时机，是在@Configguration注解中的其他逻辑被处理**之前**，
 *     具体位置在ConfigurationClassParser.processImports
 */
public class MethodCostTimeImportSelector implements ImportSelector {
  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[] {MethodCostTimeBeanPostProcessor.class.getName()};
  }
}
