package org.hanrw.spring.boot.core.conditional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author hanrw
 * @date 2020/4/28 3:41 PM
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class City {
  private String cityName;
  private Integer cityCode;
}
