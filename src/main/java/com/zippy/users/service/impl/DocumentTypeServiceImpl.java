package com.zippy.users.service.impl;

import com.zippy.users.model.DocumentType;
import org.springframework.stereotype.Service;

import com.zippy.users.service.interfaces.IDocumentTypeService;
import com.zippy.users.repository.IDocumentTypeRepository;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements IDocumentTypeService {
    private final IDocumentTypeRepository documentTypeRepository;

    public DocumentTypeServiceImpl(IDocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    @Override
    public DocumentType getDocumentTypeById(Integer id) {
        return documentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<DocumentType> getAllDocumentTypes() {
        return null;
    }

    public DocumentType getDocumentTypeByName(String name) {
        return documentTypeRepository.findByName(name);
    }


}
