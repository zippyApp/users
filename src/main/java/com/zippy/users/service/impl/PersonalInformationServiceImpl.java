package com.zippy.users.service.impl;

import com.zippy.users.model.PersonalInformation;
import com.zippy.users.service.interfaces.IPersonalInformationService;
import com.zippy.users.repository.IPersonalInformation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalInformationServiceImpl implements IPersonalInformationService {
    private final IPersonalInformation userRepository;

    public PersonalInformationServiceImpl(IPersonalInformation userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public PersonalInformation saveUser(PersonalInformation personalInformation) {
        return userRepository.save(personalInformation);
    }

    @Override
    public PersonalInformation getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<PersonalInformation> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public PersonalInformation updateUser(PersonalInformation personalInformation) {
        return userRepository.save(personalInformation);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
