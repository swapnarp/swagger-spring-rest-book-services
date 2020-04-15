package com.example.server.api;

import com.example.server.exception.DemoException;
import com.example.server.model.Book;
import com.example.server.service.BookService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Random;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/book")
public class BookApi {

    private final BookService bookService;

    @Autowired
    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "BookById")
    public Book getBookById(@PathVariable("id") Integer id) throws DemoException {
        return bookService.getById(id);
    }

    @GetMapping("/getByCategoryId")
    @ApiOperation(value = "BookByCategory")
    public List<Book> getBooksByCategory(@RequestParam("id") Integer id) {
        return bookService.getByCategoryId(id);
    }

    @PostMapping("/update")
    @ApiOperation(value = "updateById")
    public boolean update(@PathParam("id") Integer id) {
        return new Random().nextBoolean();
    }
}
