package com.book.management.msbookmanagement.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {

    @Schema(example = "Pedro Paramo")
    @NotBlank
    private String title;

    @Schema(example = "Juan Rulfo")
    @NotBlank
    private String author;

    @Schema(example = "4456778349")
    @NotBlank
    @Size(min = 10, max = 13)
    private String isbn;

    @Schema(example = "2")
    @NotNull
    private Integer quantity;

}
