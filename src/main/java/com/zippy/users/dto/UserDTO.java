package com.zippy.users.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDTO {
  private String name;
  private String email;
  private DocumentDTO document;
  private String phone;
  private String birthDate;
  private ReferenceDTO reference;
}
