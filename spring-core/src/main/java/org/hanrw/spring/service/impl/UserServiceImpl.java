package org.hanrw.spring.service.impl;

import org.hanrw.spring.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author hanrw
 * @date 2020/4/2 5:25 PM
 */
@Service
public class UserServiceImpl implements UserService {

  @Override
  public void updateUser() {
    System.out.println("更新用户");
    deleteUser();
  }

  @Override
  public void deleteUser() {
    System.out.println("删除用户");
  }
}
