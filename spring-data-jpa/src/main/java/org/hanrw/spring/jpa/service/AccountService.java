package org.hanrw.spring.jpa.service;

import org.hanrw.spring.jpa.entity.AccountInfo;

public interface AccountService {

  void create(AccountInfo accountInfo);

  AccountInfo findByAccountId(int i);
}
