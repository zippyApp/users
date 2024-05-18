package com.zippy.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ReferenceDTO {
    private Long id;

    @NotEmpty
    private String firstNames;

    @NotEmpty
    private String lastNames;

    @NotEmpty
    private String phone;

    @Email
    @NotEmpty
    private String email;

    @NotNull
    private DocumentDTO document;
}
