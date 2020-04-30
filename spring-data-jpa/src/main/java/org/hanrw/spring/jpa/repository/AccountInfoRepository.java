package org.hanrw.spring.jpa.repository;

import org.hanrw.spring.jpa.entity.AccountInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountInfoRepository extends JpaRepository<AccountInfo, Integer> {

  @Modifying
  @Query("update AccountInfo ac set ac.balance = :balance where ac.accountId = :accountId")
  int updateAccountBalance(@Param("accountId") Integer accountId, @Param("balance") double balance);

  AccountInfo findOneByAccountId(Integer accountId);
}
