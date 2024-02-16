package com.book.management.msbookmanagement.service.impl;

import com.book.management.msbookmanagement.exception.BookAlreadyAddedException;
import com.book.management.msbookmanagement.exception.BookNotFoundException;
import com.book.management.msbookmanagement.model.entity.BookEntity;
import com.book.management.msbookmanagement.model.request.BookRequest;
import com.book.management.msbookmanagement.model.response.BookResponse;
import com.book.management.msbookmanagement.repository.BookRepository;
import com.book.management.msbookmanagement.service.BookService;
import com.book.management.msbookmanagement.utils.BookMapper;
import com.book.management.msbookmanagement.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse add(BookRequest bookRequest) {

        if (bookRepository.findByIsbn(bookRequest.getIsbn()).isPresent()) {
            log.debug(Constants.BOOK_ALREADY_ADDED_LOG_MESSAGE);
            throw new BookAlreadyAddedException(Constants.BOOK_ALREADY_ADDED_EXCEPTION_MESSAGE);
        }

        BookEntity entity = BookMapper.INSTANCE.bookRequestToBookEntity(bookRequest);
        BookResponse bookResponse = BookMapper.INSTANCE.bookEntityToBookResponse(bookRepository.save(entity));
        log.info(Constants.BOOK_ADDED_SUCCESSFULLY_LOG_MESSAGE, bookResponse.getId());
        return bookResponse;

    }

    @Override
    public BookResponse getByIsbn(String isbn) {

        Optional<BookEntity> bookEntity = bookRepository.findByIsbn(isbn);

        if (!bookEntity.isPresent()) {
            log.warn(Constants.BOOK_NOT_FOUND_LOG_MESSAGE);
            throw new BookNotFoundException(Constants.BOOK_NOT_FOUND_EXCEPTION_MESSAGE);
        }

        return BookMapper.INSTANCE.bookEntityToBookResponse(bookEntity.get());
    }

    @Transactional
    @Override
    public void deleteByIsbn(String isbn) {

        log.info(Constants.BOOK_DELETING_LOG_MESSAGE, isbn);
        bookRepository.deleteByIsbn(isbn);
    }
}
