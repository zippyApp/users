package com.zippy.users.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ReferenceDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private DocumentDTO document;
}
