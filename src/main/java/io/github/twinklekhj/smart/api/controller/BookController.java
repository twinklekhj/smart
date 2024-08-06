package io.github.twinklekhj.smart.api.controller;

import io.github.twinklekhj.smart.api.service.BookService;
import io.github.twinklekhj.smart.api.type.PageVO;
import io.github.twinklekhj.smart.dao.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/api/books")
    public ResponseEntity<PageVO<Book>> getAllBooks() {
        return bookService.findAll();
    }

    @PutMapping("/api/book")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        return bookService.insert(book);
    }

    @GetMapping("/api/book/{id}")
    public ResponseEntity<?> getBookInfo(@PathVariable Long id) {
        return bookService.findById(id);
    }
}
