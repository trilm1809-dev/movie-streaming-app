package com.moviestreamingapp.server.dtos.request;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String password;
    private String fullName;
    private String role ;
    private Boolean isActive;

}
