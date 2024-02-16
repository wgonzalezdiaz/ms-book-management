package com.book.management.msbookmanagement.utils;

import com.book.management.msbookmanagement.model.entity.BookEntity;
import com.book.management.msbookmanagement.model.request.BookRequest;
import com.book.management.msbookmanagement.model.response.BookResponse;

public class Models {

    public static BookRequest buildBookRequest() {
        return BookRequest.builder().title("Juan Rulfo").author("Juan Rulfo").isbn("1234567890123").quantity(5).build();
    }

    public static BookEntity buildBookEntitySuccessFully() {
        return BookEntity.builder().id(1L).title("Pedro Paramo").author("Juan Rulfo").isbn("1234567890123").quantity(5).build();
    }

    public static BookResponse buildBookResponse() {
        return BookResponse.builder().id(1L).title("Pedro Paramo").author("Juan Rulfo").isbn("1234567890123").quantity(5).build();
    }

    public static BookRequest buildBookRequestInvalid() {
        return BookRequest.builder().title("Juan Rulfo").isbn("1234567890123").quantity(5).build();
    }
}
