package org.hanrw.spring.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductInfo {
  @Id
  @GeneratedValue
  private Integer productId;

  private String productName;

  private Integer store;

}
