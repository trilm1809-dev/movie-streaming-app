package com.moviestreamingapp.server.dtos.response;

import com.moviestreamingapp.server.entities.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private long id;
    private String email;
    private String fullName;
    private String role;
    private boolean active;
    private Instant createDate;
    private Instant updateDate;

    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getRole().name(),
                user.isActive(),
                user.getCreateAt(),
                user.getUpdateAt()
        );
    }
}
