package org.hanrw.spring.jpa.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.hanrw.spring.jpa.repository.AccountInfoRepository;
import org.hanrw.spring.jpa.repository.ProductInfoRepository;
import org.hanrw.spring.jpa.entity.AccountInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PayServiceImpl implements PayService {

  @Autowired private AccountInfoRepository accountInfoDao;

  @Autowired private ProductInfoRepository productInfoDao;

  @Override
  public void pay(Integer accountId, double money) {
    // 查询余额
    Optional<AccountInfo> accountInfo = accountInfoDao.findById(accountId);

    // 余额不足正常逻辑
    if (new BigDecimal(accountInfo.get().getBalance()).compareTo(new BigDecimal(money)) < 0) {
      throw new RuntimeException("balance insufficient");
    }

    // 更新库存
    // ((PayService) AopContext.currentProxy()).updateProductStore(1);
    // System.out.println(1/0);
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
  public void updateProductStore(Integer productId) {
    try {
      productInfoDao.updateProductInfo(productId);

    } catch (Exception e) {
      throw new RuntimeException("内部异常");
    }
  }
}
