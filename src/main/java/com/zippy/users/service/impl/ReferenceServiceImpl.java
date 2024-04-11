package com.zippy.users.service.impl;

import com.zippy.users.model.Reference;
import com.zippy.users.repository.IReferenceRepository;
import com.zippy.users.service.interfaces.IReferenceService;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceImpl implements IReferenceService{
    private final IReferenceRepository referenceRepository;

    public ReferenceServiceImpl(IReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }

    @Override
    public Reference saveReference(Reference reference) {
        return referenceRepository.save(reference);
    }
}
