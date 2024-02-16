package com.book.management.msbookmanagement.utils;

import com.book.management.msbookmanagement.model.entity.BookEntity;
import com.book.management.msbookmanagement.model.request.BookRequest;
import com.book.management.msbookmanagement.model.response.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookResponse bookEntityToBookResponse(BookEntity book);

    BookEntity bookRequestToBookEntity(BookRequest bookRequest);

}
