package com.book.management.msbookmanagement.exception;

import lombok.Getter;

@Getter
public class BookAlreadyAddedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BookAlreadyAddedException(String message) {
        super(message);
    }

}