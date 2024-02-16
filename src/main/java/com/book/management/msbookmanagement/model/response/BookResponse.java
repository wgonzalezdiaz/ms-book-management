package com.book.management.msbookmanagement.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    @Schema(example = "1234")
    private Long id;
    @Schema(example = "Pedro Paramo")
    private String title;
    @Schema(example = "Juan Rulfo")
    private String author;
    @Schema(example = "4456778349")
    private String isbn;
    @Schema(example = "2")
    private Integer quantity;

}
