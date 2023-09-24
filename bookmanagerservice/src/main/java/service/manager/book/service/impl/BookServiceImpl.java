package service.manager.book.service.impl;

import org.springframework.stereotype.Service;
import service.manager.book.exception.BookFailedToDelete;
import service.manager.book.exception.BookFailedToSaved;
import service.manager.book.exception.BookNotFoundException;
import service.manager.book.model.Book;
import service.manager.book.repository.BookRepository;
import service.manager.book.service.BookService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.findAll();
    }
    @Override
    public Book getBookById(Long id) {
        Optional<Book> book =bookRepository.findById(id);
        if(book.isPresent()) {
            return book.get();
        }
        throw new BookNotFoundException("Book Not found by Id: "+id);
    }
    @Override
    public String addBook(Book book) {
        String message ="Book is not saved...!";
        if(book!=null) {
            bookRepository.save(book);
            return "Book Saved successfully!!!";
        }
        throw new BookFailedToSaved(message);
    }
    @Override
    public String deleteBook(Long id) {
        String message ="Book failed to Delete!!!";
        Optional<Book> book =bookRepository.findById(id);
        if(book.isPresent()){
            Book opt = book.get();
            bookRepository.delete(opt);
            return "Book Deleted Successfully!!!";
        }
        throw new BookFailedToDelete(message);
    }

    @Override
    public String updateBook(Book book, Long id) {
        if(id!=null && book!=null){
            Optional<Book> bookFind =bookRepository.findById(id);
            if(bookFind.isPresent()){
                Book opt =bookFind.get();
                if(book.getPrice()!=null)
                    opt.setPrice(book.getPrice());
                if(book.getAuthor()!=null)
                    opt.setAuthor(book.getTitle());
                if(book.getTitle()!=null)
                    opt.setTitle(book.getTitle());
                bookRepository.save(opt);
                return "Book details update successfully!!!";
            }else{
                throw new BookNotFoundException("Book not found for the Id: "+id);
            }
        }else
            throw new BookNotFoundException("Unknown server error!");
    }
}
