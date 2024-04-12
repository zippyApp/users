package com.zippy.users.controller;

import com.zippy.users.dto.DocumentDTO;
import com.zippy.users.dto.DocumentTypeDTO;
import com.zippy.users.mappers.DocumentMapper;
import com.zippy.users.mappers.DocumentTypeMapper;
import com.zippy.users.service.interfaces.IDocumentService;
import com.zippy.users.service.interfaces.IDocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentController {
    private IDocumentTypeService documentTypeService;
    private IDocumentService documentService;

    private DocumentTypeMapper documentTypeMapper;
    private DocumentMapper documentMapper;

    @GetMapping("/types")
    public ResponseEntity<List<DocumentTypeDTO>> getAllDocumentTypes() {
        return ResponseEntity.ok(documentTypeService.getAllDocumentTypes().stream().map(documentTypeMapper::DocumentTypeToDocumentTypeDTO).toList());
    }

    @GetMapping("/types/{id}")
    public ResponseEntity<DocumentTypeDTO> getDocumentTypeById(@PathVariable Integer id) {
        return ResponseEntity.ok(documentTypeMapper.DocumentTypeToDocumentTypeDTO(documentTypeService.getDocumentTypeById(id)));
    }

    @PutMapping("/{id}/type/update")
    public ResponseEntity<DocumentDTO> updateDocumentType(@PathVariable Long id, @RequestHeader("Document-Type") Integer typeId) {
        return (documentService.updateDocumentType(id, typeId)
                .map(documentMapper::DocumentToDocumentDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()
                ));
    }

    @Autowired
    public void setDocumentTypeService(IDocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @Autowired
    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }

    @Autowired
    public void setDocumentTypeMapper(DocumentTypeMapper documentTypeMapper) {
        this.documentTypeMapper = documentTypeMapper;
    }

    @Autowired
    public void setDocumentMapper(DocumentMapper documentMapper) {
        this.documentMapper = documentMapper;
    }
}
