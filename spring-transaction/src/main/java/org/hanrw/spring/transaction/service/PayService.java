package org.hanrw.spring.transaction.service;

public interface PayService {

  void pay(String accountId, double money);

  void updateProductStore(Integer productId);
}
