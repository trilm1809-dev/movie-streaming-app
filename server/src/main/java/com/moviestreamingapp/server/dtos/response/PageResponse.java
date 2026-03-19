package com.moviestreamingapp.server.dtos.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
@NotBlank
public class PageResponse<T> {
    private List<T> content;
    private int totalElement;
    private int totalPages;
    private int number;
    private int size;
}
