package com.zippy.users.controller;

import com.zippy.users.dto.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zippy.users.service.interfaces.IDocumentTypeService;
import com.zippy.users.service.interfaces.IDocumentService;

import com.zippy.users.dto.DocumentTypeDTO;

import com.zippy.users.mappers.DocumentTypeMapper;
import com.zippy.users.mappers.DocumentMapper;

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

    @PutMapping("/{id}/type/{typeId}")
    public ResponseEntity<DocumentDTO> updateDocumentType(@PathVariable  Long id, @PathVariable  Integer typeId) {
        return ResponseEntity.ok(documentMapper.DocumentToDocumentDTO(documentService.updateDocumentType(id, typeId)));
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
