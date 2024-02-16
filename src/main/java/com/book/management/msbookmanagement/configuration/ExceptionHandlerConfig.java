package com.book.management.msbookmanagement.configuration;

import com.book.management.msbookmanagement.exception.BookAlreadyAddedException;
import com.book.management.msbookmanagement.exception.BookNotFoundException;
import com.book.management.msbookmanagement.model.response.ErrorResponse;
import com.book.management.msbookmanagement.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class ExceptionHandlerConfig {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList().toString());

        log.error(Constants.ERROR_RESPONSE_HANDLER_MESSAGE, errorResponse);

        return errorResponse;

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BookNotFoundException.class)
    public ErrorResponse handleBookNotFoundException(BookNotFoundException ex) {

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(ex.getMessage());

        log.error(Constants.ERROR_RESPONSE_HANDLER_MESSAGE, errorResponse);

        return errorResponse;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BookAlreadyAddedException.class)
    public ErrorResponse handleBookAlreadyAddedException(BookAlreadyAddedException ex) {

        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(ex.getMessage());

        log.error(Constants.ERROR_RESPONSE_HANDLER_MESSAGE, errorResponse);

        return errorResponse;

    }


}
