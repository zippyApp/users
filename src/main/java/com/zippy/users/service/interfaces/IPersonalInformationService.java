package com.zippy.users.service.interfaces;

import com.zippy.users.model.PersonalInformation;

import java.util.List;
import java.util.Optional;

public interface IPersonalInformationService {
    PersonalInformation savePersonalInformation(PersonalInformation personalInformation);

    Optional<PersonalInformation> getPersonalInformationById(Long id);

    List<PersonalInformation> getAllPersonalInformation();

    Optional<PersonalInformation> newPersonalInformation(PersonalInformation personalInformation);

    PersonalInformation updatePersonalInformation(PersonalInformation personalInformation);

    void deletePersonalInformation(Long id);
}
