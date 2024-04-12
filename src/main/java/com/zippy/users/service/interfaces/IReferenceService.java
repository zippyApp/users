package com.zippy.users.service.interfaces;

import com.zippy.users.model.Reference;

import java.util.Optional;

public interface IReferenceService {
    Reference saveReference(Reference reference);

    Optional<Reference> newReference(Reference reference);

    void deleteReference(Long referenceId);
}
