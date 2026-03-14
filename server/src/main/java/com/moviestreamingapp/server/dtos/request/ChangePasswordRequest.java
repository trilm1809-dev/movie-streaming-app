package com.moviestreamingapp.server.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChangePasswordRequest {

    @NotBlank(message = "Curent Password is required")
    private String currentPassword;

    @NotBlank(message = "New Password is Required")
    private String newPassword;
}
