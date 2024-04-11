package com.zippy.users.mappers;

import com.zippy.users.dto.DocumentDTO;
import com.zippy.users.model.Document;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = DocumentTypeMapper.class)
public interface DocumentMapper {
    @Mapping(target = "type", source = "document.type")
    DocumentDTO DocumentToDocumentDTO(Document document);
    Document DocumentDTOtoDocument(DocumentDTO documentDTO);
}
