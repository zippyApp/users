package com.zippy.users.service.interfaces;

import com.zippy.users.model.Document;

import java.util.List;
import java.util.Optional;

public interface IDocumentService {
    Document saveDocument(Document document);

    Document getDocumentById(Long id);

    List<Document> getAllDocuments();

    Document updateDocument(Document document);

    void deleteDocument(Long id);

    Optional<Document> updateDocumentType(Long id, Integer typeId);

    Optional<Document> newDocument(Document document);
}
