package com.zippy.users.repository;

import com.zippy.users.model.PersonalInformation;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IPersonalInformation extends JpaRepository<PersonalInformation, Long>{
    PersonalInformation findUserById(Long id);
}
