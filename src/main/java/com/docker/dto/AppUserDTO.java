package com.docker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
