package com.book.management.msbookmanagement.controller;

import com.book.management.msbookmanagement.model.request.BookRequest;
import com.book.management.msbookmanagement.model.response.BookResponse;
import com.book.management.msbookmanagement.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "BookManagement", description = "Book Management API")
@RequestMapping("/api/v1/management")
@RestController
public class BookManagementController {

    private final BookService bookService;

    @Autowired
    public BookManagementController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(
            summary = "Add Book into database",
            description = "Add Book into database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book added successfully")
    })
    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse add(@Valid @RequestBody BookRequest bookRequest) {
        return bookService.add(bookRequest);
    }


    @Operation(
            summary = "Retrieving a book by isbn",
            description = "Find a Book by ISBN in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book consulted successfully")
    })
    @GetMapping("/book/{isbn}")
    public BookResponse getByIsbn(@PathVariable(name = "isbn") String isbn) {
        return bookService.getByIsbn(isbn);
    }

    @Operation(
            summary = "Delete a book by isbn",
            description = "Delete a Book by ISBN in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Book deleted successfully")
    })
    @DeleteMapping("/book/{isbn}")
    public void deleteByIsbn(@PathVariable(name = "isbn") String isbn) {
        bookService.deleteByIsbn(isbn);
    }

}
