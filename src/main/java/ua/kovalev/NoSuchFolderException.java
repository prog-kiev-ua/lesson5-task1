package ua.kovalev;

public class NoSuchFolderException extends Exception{
    public NoSuchFolderException(String message) {
        super(message);
    }

    public NoSuchFolderException() {
        super();
    }
}
