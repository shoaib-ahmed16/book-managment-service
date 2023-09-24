package service.manager.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.manager.book.exception.BookNotFoundException;
import service.manager.book.model.Book;
import service.manager.book.service.BookService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class BookController {

    private BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> bookList = bookService.getAllBookList();
        if(bookList.isEmpty())
            throw  new BookNotFoundException("No Books found!!!");
        return  new ResponseEntity<>(bookList, HttpStatus.ACCEPTED);
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        return  new ResponseEntity<>(bookService.getBookById(id),HttpStatus.ACCEPTED);
    }

    @PostMapping("/books")
    public ResponseEntity<String> addNewBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book),HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<String> updateBookById(@RequestBody Book book,@PathVariable("id") Long id){
        return new ResponseEntity<>(bookService.updateBook(book,id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id){
        return new ResponseEntity<>(bookService.deleteBook(id),HttpStatus.ACCEPTED);
    }

}
