package com.zippy.users.mappers;

import com.zippy.users.dto.DocumentDTO;
import com.zippy.users.dto.DocumentTypeDTO;
import com.zippy.users.model.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = DocumentTypeDTO.class)
public interface DocumentMapper {

    @Mapping(target = "type", source = "document.type")
    DocumentDTO DocumentToDocumentDTO(Document document);

    @Mapping(target = "type", source = "type")
    @Mapping(target = "id", ignore = true)
    Document DocumentDTOtoDocument(DocumentDTO documentDTO);

    default DocumentTypeDTO DocumentTypeDTOFromId(Integer id) {
        if (id == null) {
            return null;
        }
        return DocumentTypeDTO.builder()
                .id(id)
                .build();
    }


}
