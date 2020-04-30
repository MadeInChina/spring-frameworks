package org.hanrw.spring.jpa.service;

public interface PayService {

  void pay(Integer accountId, double money);

  void updateProductStore(Integer productId);
}
