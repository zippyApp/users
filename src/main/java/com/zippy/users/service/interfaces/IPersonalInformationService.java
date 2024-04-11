package com.zippy.users.service.interfaces;
import com.zippy.users.model.PersonalInformation;

import java.util.List;

public interface IPersonalInformationService {
  PersonalInformation saveUser(PersonalInformation personalInformation);
  PersonalInformation getUserById(Long id);
  List<PersonalInformation> getAllUsers();
  PersonalInformation updateUser(PersonalInformation personalInformation);
  void deleteUser(Long id);
}
