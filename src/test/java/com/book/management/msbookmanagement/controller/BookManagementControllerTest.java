package com.book.management.msbookmanagement.controller;

import com.book.management.msbookmanagement.model.request.BookRequest;
import com.book.management.msbookmanagement.model.response.BookResponse;
import com.book.management.msbookmanagement.service.BookService;
import com.book.management.msbookmanagement.utils.Models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookManagementControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookManagementController controller;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addSuccessfullyTest() {
        //given
        BookRequest request = Models.buildBookRequest();
        BookResponse bookResponse = Models.buildBookResponse();
        //when
        Mockito.when(bookService.add(request)).thenReturn(bookResponse);
        //then
        BookResponse response = controller.add(request);

        assertNotNull(response);
    }

    @Test
    void getByIsbnSuccessfullyTest() {
        //given
        String isbn = "1234567890";
        BookResponse bookResponse = Models.buildBookResponse();
        //when
        Mockito.when(bookService.getByIsbn(isbn)).thenReturn(bookResponse);
        //then
        BookResponse response = controller.getByIsbn(isbn);

        assertNotNull(response);
    }

    @Test
    void deleteByIsbnSuccessfullyTest() {
        //given
        String isbn = "1234567890";
        BookResponse bookResponse = Models.buildBookResponse();
        //when
        Mockito.doNothing().when(bookService).deleteByIsbn(isbn);
        //then
        assertDoesNotThrow(() -> controller.deleteByIsbn(isbn));
    }
    
}
