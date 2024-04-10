package com.zippy.users.service.interfaces;
import com.zippy.users.model.User;
import java.util.List;

public interface IUserService {
  User saveUser(User user);
  User getUserById(Long id);
  List<User> getAllUsers();
  User updateUser(User user);
  void deleteUser(Long id);
}
