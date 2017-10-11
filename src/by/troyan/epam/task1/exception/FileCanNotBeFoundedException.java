package by.troyan.epam.task1.exception;

public class FileCanNotBeFoundedException extends ShapesException {
    public FileCanNotBeFoundedException(String detail) {
        super(detail);
    }

    public FileCanNotBeFoundedException(String message, String detail) {
        super(message, detail);
    }

    public FileCanNotBeFoundedException(String message, Throwable cause, String detail) {
        super(message, cause, detail);
    }

    public FileCanNotBeFoundedException(Throwable cause, String detail) {
        super(cause, detail);
    }

    @Override
    public String toString() {
        return "FileCanNotBeFoundedException{}";
    }
}
