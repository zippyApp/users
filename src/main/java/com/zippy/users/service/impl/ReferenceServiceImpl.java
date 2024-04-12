package com.zippy.users.service.impl;

import com.zippy.users.model.Reference;
import com.zippy.users.repository.IReferenceRepository;
import com.zippy.users.service.interfaces.IDocumentService;
import com.zippy.users.service.interfaces.IReferenceService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReferenceServiceImpl implements IReferenceService {
    private IReferenceRepository referenceRepository;
    private IDocumentService documentService;

    @Override
    public Reference saveReference(Reference reference) {
        return referenceRepository.save(reference);
    }

    @Override
    public Optional<Reference> newReference(Reference reference) {
        return saveReferenceDocument(reference)
                .map(this::saveReference);
    }

    @Override
    public void deleteReference(Long referenceId) {
        referenceRepository.deleteById(referenceId);
    }


    private Optional<Reference> saveReferenceDocument(@NotNull Reference reference) {
        return documentService.newDocument(reference.getDocument())
                .map(document -> reference.setDocumentId(document.getId()));
    }

    @Autowired
    public void setReferenceRepository(IReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }

    @Autowired
    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }
}
