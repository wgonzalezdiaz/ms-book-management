package com.book.management.msbookmanagement.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    public static final String ERROR_RESPONSE_HANDLER_MESSAGE = "An exception has occurred: [{}]";
    public static final String BOOK_NOT_FOUND_EXCEPTION_MESSAGE = "No book associated with the isbn was found";
    public static final String BOOK_ALREADY_ADDED_EXCEPTION_MESSAGE = "The book is already added.";
    public static final String BOOK_ALREADY_ADDED_LOG_MESSAGE = "The book already exists";
    public static final String BOOK_ADDED_SUCCESSFULLY_LOG_MESSAGE = "Book id [{}] successfully added";
    public static final String BOOK_NOT_FOUND_LOG_MESSAGE = "Book not found";
    public static final String BOOK_DELETING_LOG_MESSAGE = "Deleting isbn [{}]";
}
