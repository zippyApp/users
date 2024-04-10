package com.zippy.users.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DocumentDTO {
    private String number;
    private DocumentTypeDTO type;
    private String frontImage;
    private String backImage;
}
