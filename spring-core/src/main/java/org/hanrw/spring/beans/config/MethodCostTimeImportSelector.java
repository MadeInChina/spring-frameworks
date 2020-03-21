package org.hanrw.spring.beans.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
/**
 * @author hanrw
 * @date 2020/3/21 11:49 AM
 */
public class MethodCostTimeImportSelector implements ImportSelector {
  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[] {MethodCostTimeBeanPostProcessor.class.getName()};
  }
}
