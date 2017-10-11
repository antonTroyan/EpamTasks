package by.troyan.epam.task1v2.exception;

public class FileIsEmptyException extends ShapesException {
    public FileIsEmptyException(String detail) {
        super(detail);
    }

    public FileIsEmptyException(String message, String detail) {
        super(message, detail);
    }

    public FileIsEmptyException(String message, Throwable cause, String detail) {
        super(message, cause, detail);
    }

    public FileIsEmptyException(Throwable cause, String detail) {
        super(cause, detail);
    }

    @Override
    public String toString() {
        return "FileIsEmptyException{}";
    }
}
