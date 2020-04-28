package org.hanrw.spring.boot.core.conditional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author hanrw
 * @date 2020/4/28 3:40 PM
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class People {
  private String name;
  private Integer age;
  private City city;
}
