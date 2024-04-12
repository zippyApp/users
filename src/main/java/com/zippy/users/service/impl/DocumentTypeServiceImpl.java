package com.zippy.users.service.impl;

import com.zippy.users.model.DocumentType;
import com.zippy.users.repository.IDocumentTypeRepository;
import com.zippy.users.service.interfaces.IDocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements IDocumentTypeService {
    private IDocumentTypeRepository documentTypeRepository;

    @Override
    public DocumentType getDocumentTypeById(Integer id) {
        return documentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<DocumentType> getAllDocumentTypes() {
        return documentTypeRepository.findAll();
    }

    @Override
    public boolean existsDocumentTypeById(Integer id) {
        return documentTypeRepository.existsById(id);
    }

    @Autowired
    public void setDocumentTypeRepository(IDocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

}
