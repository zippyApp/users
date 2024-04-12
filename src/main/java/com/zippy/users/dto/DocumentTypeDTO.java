package com.zippy.users.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Builder
@Getter
@Setter
public class DocumentTypeDTO {
    @NotNull
    private Integer id;

    private String name;
}
