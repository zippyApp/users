package com.zippy.users.controller;

import com.zippy.users.dto.PersonalInformationDTO;
import com.zippy.users.mappers.PersonalInformationMapper;
import com.zippy.users.model.PersonalInformation;
import com.zippy.users.service.interfaces.IDocumentService;
import com.zippy.users.service.interfaces.IDocumentTypeService;
import com.zippy.users.service.interfaces.IReferenceService;
import com.zippy.users.service.interfaces.IPersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private IPersonalInformationService userService;
    private IDocumentService documentService;
    private IReferenceService referenceService;
    private IDocumentTypeService documentTypeService;

    private PersonalInformationMapper personalInformationMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PersonalInformationDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(personalInformationMapper
                .PersonalInformatonToPersonalInformationDTO(userService.getUserById(id)));
    }

    @GetMapping("/")
    public ResponseEntity<List<PersonalInformationDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers().stream()
                .map(personalInformationMapper::PersonalInformatonToPersonalInformationDTO).toList());
    }

    @PostMapping("/add")
    public ResponseEntity<PersonalInformationDTO> addUser(@RequestBody PersonalInformationDTO personalInformationDTO) {
        PersonalInformation personalInformationMapped = personalInformationMapper
                .PersonalInformatonDTOToPersonalInformation(personalInformationDTO);
        if (personalInformationMapped.getDocument().getType() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (documentTypeService.getDocumentTypeById(personalInformationMapped.getDocument().getType().getId()) == null) {
            return ResponseEntity.badRequest().build();
        }

        PersonalInformation personalInformation = userService.saveUser(personalInformationMapped
                .setDocument(documentService.saveDocument(
                        personalInformationMapped.getDocument()
                ))
                .setReference(referenceService.saveReference(personalInformationMapped.getReference()
                                .setDocument(documentService.saveDocument(
                                        personalInformationMapped.getReference().getDocument()
                                ))))
        );
        URI location = URI.create("/api/v1/users/" + personalInformation.getId());
        return ResponseEntity.created(location).body(personalInformationMapper
                .PersonalInformatonToPersonalInformationDTO(personalInformation));
    }

    @Autowired
    public void setUserService(IPersonalInformationService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(PersonalInformationMapper personalInformationMapper) {
        this.personalInformationMapper = personalInformationMapper;
    }

    @Autowired
    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }

    @Autowired
    public void setReferenceService(IReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    @Autowired
    public void setDocumentTypeService(IDocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

}
