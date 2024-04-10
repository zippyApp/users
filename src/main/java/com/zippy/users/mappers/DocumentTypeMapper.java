package com.zippy.users.mappers;

import com.zippy.users.dto.DocumentTypeDTO;
import com.zippy.users.model.DocumentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentTypeMapper {
    @Mapping(target = "id", ignore = true)
    DocumentTypeDTO DocumentTypeToDocumentTypeDTO(DocumentType documentType);
    DocumentType DocumentTypeDTOtoDocumentType(DocumentTypeDTO documentTypeDTO);
}
