package com.zippy.users.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PersonalInformationDTO {
  private Long id;
  private String firstNames;
  private String lastNames;
  private String occupation;
  private String email;
  private DocumentDTO document;
  private String phone;
  private String birthDate;
  private ReferenceDTO reference;
}
