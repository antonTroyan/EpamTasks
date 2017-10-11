package by.troyan.epam.task1.exception;

public class NoFileNameException extends ShapesException {

    public NoFileNameException(String detail) {
        super(detail);
    }

    public NoFileNameException(String message, String detail) {
        super(message, detail);
    }

    public NoFileNameException(String message, Throwable cause, String detail) {
        super(message, cause, detail);
    }

    public NoFileNameException(Throwable cause, String detail) {
        super(cause, detail);
    }

    @Override
    public String toString() {
        return "NoFileNameException{}";
    }
}
