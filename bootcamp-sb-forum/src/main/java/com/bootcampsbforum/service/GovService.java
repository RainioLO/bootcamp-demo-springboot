package com.bootcampsbforum.service;

import java.util.List;
import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import com.bootcampsbforum.model.dto.jph.User;

public interface GovService { // not in the database stage
  
  /**
   * 1. Invoke JPH API to retrieve User List
   * 2. Store/ refresh the whole user list in database
   * 3. return to Gov
   * @param id
   * @return
   */
  User getUser(int id);

  List<User> getUsers();

}
