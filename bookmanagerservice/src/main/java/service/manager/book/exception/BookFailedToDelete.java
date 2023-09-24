package service.manager.book.exception;

public class BookFailedToDelete extends RuntimeException {
    public BookFailedToDelete(String message) {
        super(message);
    }
    public BookFailedToDelete( ) {
    }
}
