package com.zippy.users.service.impl;

import com.zippy.users.model.Document;
import com.zippy.users.service.interfaces.IDocumentService;
import com.zippy.users.repository.IDocumentRepository;
import com.zippy.users.service.interfaces.IDocumentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements IDocumentService {
    private final IDocumentRepository documentRepository;

    public DocumentServiceImpl(IDocumentRepository documentRepository, IDocumentTypeService documentTypeService) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document getDocumentById(Long id) {
        return null;
    }

    @Override
    public List<Document> getAllDocuments() {
        return List.of();
    }

    @Override
    public Document updateDocument(Document document) {
        return null;
    }

    @Override
    public void deleteDocument(Long id) {

    }
}
