package com.zippy.users.service.interfaces;

import com.zippy.users.model.DocumentType;
import java.util.List;

public interface IDocumentTypeService {
  DocumentType getDocumentTypeById(Integer id);
  List<DocumentType> getAllDocumentTypes();
  DocumentType getDocumentTypeByName(String name);
}
