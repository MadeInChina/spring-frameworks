package org.hanrw.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

import lombok.Data;

@Entity
@Table(indexes = {@Index(columnList = "accountId")})
@Data
public class AccountInfo implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id @GeneratedValue private Integer id;

  @Column private Integer accountId;

  @Column private double balance;
}
