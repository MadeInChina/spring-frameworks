package org.hanrw.spring.boot.autoconfiguration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hanrw
 * @date 2020/3/23 1:43 PM
 */
public class MyImportSelector implements ImportSelector {

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[] {MyConfiguration.class.getName()};
  }
}
