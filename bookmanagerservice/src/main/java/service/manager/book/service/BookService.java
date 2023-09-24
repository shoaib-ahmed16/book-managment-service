package service.manager.book.service;

import service.manager.book.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBookList();
    Book getBookById(Long id);

    String addBook(Book book);
    String deleteBook(Long id);
    String updateBook(Book book,Long id);

}
