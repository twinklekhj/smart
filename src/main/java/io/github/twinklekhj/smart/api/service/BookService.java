package io.github.twinklekhj.smart.api.service;

import io.github.twinklekhj.smart.dao.CrudQuery;
import io.github.twinklekhj.smart.dao.CrudService;
import io.github.twinklekhj.smart.dao.entity.Book;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends CrudService<Book, Long> {
    @Autowired
    public BookService(SqlSessionTemplate template) {
        super(template);
        setQuery(CrudQuery.builder()
                .insert("book.insertBookInfo")
                .update("book.updateBookInfo")
                .check("book.checkBookInfo")
                .count("book.getCount")
                .selectList("book.getBookList")
                .selectOne("book.getBookInfo")
                .build());
    }
}
