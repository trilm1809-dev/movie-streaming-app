package com.moviestreamingapp.server.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class VideoRequest {

    @NotBlank(message = "Title is require")
    private String title;

    @Size(max = 4000, message = "Description must not exceed 4000 characters")
    private String description;
    private Integer year;
    private Integer rating;
    private String src;
    private String poster;
    private boolean published;
    private List<String> categories;

}
