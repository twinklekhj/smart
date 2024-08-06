package io.github.twinklekhj.smart.dao.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Book {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private LocalDateTime createDate;
    private LocalDateTime editDate;
}
