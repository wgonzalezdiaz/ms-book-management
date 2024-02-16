package com.book.management.msbookmanagement.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ErrorResponse {

    @Schema(description = "Http Code", example = "404")
    private int code;
    @Schema(description = "Message of exception", example = "Book not found")
    private String message;
}
