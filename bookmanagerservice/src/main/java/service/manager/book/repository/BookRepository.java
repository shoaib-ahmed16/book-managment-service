package service.manager.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.manager.book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
