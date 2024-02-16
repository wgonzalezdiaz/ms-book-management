package com.book.management.msbookmanagement.service;


import com.book.management.msbookmanagement.exception.BookAlreadyAddedException;
import com.book.management.msbookmanagement.exception.BookNotFoundException;
import com.book.management.msbookmanagement.model.entity.BookEntity;
import com.book.management.msbookmanagement.model.request.BookRequest;
import com.book.management.msbookmanagement.model.response.BookResponse;
import com.book.management.msbookmanagement.repository.BookRepository;
import com.book.management.msbookmanagement.service.impl.BookServiceImpl;
import com.book.management.msbookmanagement.utils.Constants;
import com.book.management.msbookmanagement.utils.Models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addSuccessfullyTest() {
        //given
        BookRequest request = Models.buildBookRequest();
        Long expected = 1L;
        //when
        Mockito.when(bookRepository.findByIsbn(request.getIsbn())).thenReturn(Optional.empty());
        //then
        BookEntity entity = Models.buildBookEntitySuccessFully();
        Mockito.when(bookRepository.save(Mockito.any(BookEntity.class))).thenReturn(entity);

        BookResponse bookResponse = bookService.add(request);

        assertEquals(expected, bookResponse.getId());
    }

    @Test
    void addWithBookAlreadyAddedExceptionTest() {
        //given
        String expectedMessage = Constants.BOOK_ALREADY_ADDED_EXCEPTION_MESSAGE;
        BookRequest request = Models.buildBookRequest();
        //when
        Mockito.when(bookRepository.findByIsbn(request.getIsbn())).thenReturn(Optional.of(Models.buildBookEntitySuccessFully()));
        //then
        Exception exception = assertThrows(BookAlreadyAddedException.class, () ->
                bookService.add(request)
        );

        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void getBookByIsbnSuccessfullyTest() {
        //given
        String isbn = "1234567890";
        BookEntity entity = Models.buildBookEntitySuccessFully();
        //when
        Mockito.when(bookRepository.findByIsbn(isbn)).thenReturn(Optional.of(entity));
        //then
        BookResponse response = bookService.getByIsbn(isbn);

        assertNotNull(response);
    }

    @Test
    void getBookByIsbnWithBookNotFoundExceptionTest() {
        //given
        String expectedMessage = Constants.BOOK_NOT_FOUND_EXCEPTION_MESSAGE;
        String isbn = "1234567890";
        //when
        Mockito.when(bookRepository.findByIsbn(isbn)).thenReturn(Optional.empty());
        //then
        Exception exception = assertThrows(BookNotFoundException.class, () ->
                bookService.getByIsbn(isbn)
        );

        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void deleteBookByIsbnTest() {
        //given
        String isbn = "1234567890";
        //when
        Mockito.doNothing().when(bookRepository).deleteByIsbn(isbn);
        //then
        assertDoesNotThrow(() -> bookService.deleteByIsbn(isbn));
    }

}

