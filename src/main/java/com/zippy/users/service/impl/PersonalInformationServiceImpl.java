package com.zippy.users.service.impl;

import com.zippy.users.model.Document;
import com.zippy.users.model.PersonalInformation;
import com.zippy.users.repository.IPersonalInformation;
import com.zippy.users.service.interfaces.IDocumentService;
import com.zippy.users.service.interfaces.IPersonalInformationService;
import com.zippy.users.service.interfaces.IReferenceService;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalInformationServiceImpl implements IPersonalInformationService {
    private IPersonalInformation personalInformationRepository;
    private IDocumentService documentService;
    private IReferenceService referenceService;

    @Override
    public PersonalInformation savePersonalInformation(PersonalInformation personalInformation) {
        return personalInformationRepository.save(personalInformation);
    }

    @Override
    public Optional<PersonalInformation> getPersonalInformationById(Long id) {
        return personalInformationRepository.findById(id);
    }

    @Override
    public List<PersonalInformation> getAllPersonalInformation() {
        return personalInformationRepository.findAll();
    }

    @Override
    public PersonalInformation updatePersonalInformation(PersonalInformation personalInformation) {
        return personalInformationRepository.save(personalInformation);
    }

    @Override
    public void deletePersonalInformation(Long id) {
        personalInformationRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<PersonalInformation> newPersonalInformation(@NotNull PersonalInformation personalInformation) {
        return savePersonalInformationDocument(personalInformation)
                .flatMap(this::savePersonalInformationReference)
                .map(this::savePersonalInformation);
    }

    private Optional<PersonalInformation> savePersonalInformationDocument(@NotNull PersonalInformation personalInformation) {
        return documentService.newDocument(personalInformation.getDocument())
                .map(document -> personalInformation.setDocumentId(document.getId()));
    }

    private Optional<PersonalInformation> savePersonalInformationReference(@NotNull PersonalInformation personalInformation) {
        return referenceService.newReference(personalInformation.getReference())
                .map(reference -> personalInformation.setReferenceId(reference.getId()));
    }

    @Autowired
    public void setPersonalInformationRepository(IPersonalInformation personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }

    @Autowired
    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }

    @Autowired
    public void setReferenceService(IReferenceService referenceService) {
        this.referenceService = referenceService;
    }
}
