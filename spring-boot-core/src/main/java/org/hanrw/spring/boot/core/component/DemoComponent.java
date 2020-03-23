package org.hanrw.spring.boot.core.component;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author hanrw
 * @date 2020/3/22 2:58 PM
 */
@Data
@Component
public class DemoComponent {
  private String name = "demo";
}
