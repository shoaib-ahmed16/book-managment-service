package service.manager.book.exception;

public class BookFailedToSaved extends RuntimeException{
    public BookFailedToSaved(){

    }
    public BookFailedToSaved(String message){
        super(message);
    }
}

