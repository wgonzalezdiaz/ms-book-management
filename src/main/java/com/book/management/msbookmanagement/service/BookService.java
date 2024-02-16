package com.book.management.msbookmanagement.service;

import com.book.management.msbookmanagement.model.request.BookRequest;
import com.book.management.msbookmanagement.model.response.BookResponse;

public interface BookService {

    BookResponse add(BookRequest bookRequest);

    BookResponse getByIsbn(String isbn);

    void deleteByIsbn(String isbn);
}
