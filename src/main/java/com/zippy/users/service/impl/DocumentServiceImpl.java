package com.zippy.users.service.impl;

import com.zippy.users.model.Document;
import com.zippy.users.repository.IDocumentRepository;
import com.zippy.users.service.interfaces.IDocumentService;
import com.zippy.users.service.interfaces.IDocumentTypeService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements IDocumentService {
    private IDocumentRepository documentRepository;
    private IDocumentTypeService documentTypeService;

    @Override
    public Optional<Document> newDocument(Document document) {
        return documentTypeExists(document.getTypeId())
                .flatMap(exists -> exists ?
                        Optional.of(saveDocument(document)) :
                        Optional.empty()
                );
    }

    @Override
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document updateDocument(Document document) {
        return saveDocument(document);
    }

    @Override
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public Optional<Document> updateDocumentType(Long id, Integer typeId) {
        return documentTypeExists(typeId)
                .flatMap(exists -> exists ? findDocumentById(id) : Optional.empty())
                .map(document -> updateDocument(document.setTypeId(typeId)));
    }

    private Optional<Boolean> documentTypeExists(@NotNull Integer typeId) {
        return Optional.of(documentTypeService.existsDocumentTypeById(typeId));
    }

    private Optional<Document> findDocumentById(@NotNull Long id) {
        return documentRepository.findById(id);
    }

    @Autowired
    public void setDocumentRepository(IDocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Autowired
    public void setDocumentTypeService(IDocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }
}
