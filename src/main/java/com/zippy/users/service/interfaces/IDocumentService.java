package com.zippy.users.service.interfaces;

import com.zippy.users.model.Document;
import java.util.List;

public interface IDocumentService {
  Document saveDocument(Document document);
  Document getDocumentById(Long id);
  List<Document> getAllDocuments();
  Document updateDocument(Document document);
  void deleteDocument(Long id);
}
