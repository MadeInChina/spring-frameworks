package org.hanrw.spring.jpa.service;

import org.hanrw.spring.jpa.entity.AccountInfo;
import org.hanrw.spring.jpa.repository.AccountInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired AccountInfoRepository accountInfoRepository;

  @Override
  public void create(AccountInfo accountInfo) {
    accountInfoRepository.save(accountInfo);
  }

  @Override
  public AccountInfo findByAccountId(int accountId) {
    return accountInfoRepository.findOneByAccountId(accountId);
  }
}
