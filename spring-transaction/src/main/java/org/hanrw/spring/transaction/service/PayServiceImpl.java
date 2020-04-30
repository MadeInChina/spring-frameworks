package org.hanrw.spring.transaction.service;

import java.math.BigDecimal;

import org.hanrw.spring.transaction.dao.AccountInfoDao;
import org.hanrw.spring.transaction.dao.ProductInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PayServiceImpl implements PayService {

  @Autowired private AccountInfoDao accountInfoDao;

  @Autowired private ProductInfoDao productInfoDao;

  @Override
  @Transactional
  public void pay(String accountId, double money) {
    // 查询余额
    double balance = accountInfoDao.qryBalanceByUserId(accountId);

    // 余额不足正常逻辑
    if (new BigDecimal(balance).compareTo(new BigDecimal(money)) < 0) {
      throw new RuntimeException("balance insufficient");
    }

    //更新库存
    //((PayService) AopContext.currentProxy()).updateProductStore(1);
    //System.out.println(1/0);
    // 这里不会使用使用一个新的事务,因为直接调用方法不会走代理对象
    // updateProductStore(2);
    // 下面的方法是直接获取代理对象,所以可以使用新的事务
    // ((PayService) AopContext.currentProxy()).updateProductStore(2);
    // 模拟业务异常
    // System.out.println(1/0);
    // 更新余额
    int retVal = accountInfoDao.updateAccountBalance(accountId, money);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void updateProductStore(Integer productId) {
    try {
      productInfoDao.updateProductInfo(productId);

    } catch (Exception e) {
      throw new RuntimeException("内部异常");
    }
  }
}
