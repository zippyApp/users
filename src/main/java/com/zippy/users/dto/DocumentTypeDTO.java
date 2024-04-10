package com.zippy.users.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DocumentTypeDTO {
    private Integer id;
    private String name;
}
