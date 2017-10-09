package by.antontroyan.epam.tasks.task1;

public class NoValidDataException extends ShapesException {

    public NoValidDataException(String detail) {
        super(detail);
    }

    public NoValidDataException(String message, String detail) {
        super(message, detail);
    }

    public NoValidDataException(String message, Throwable cause, String detail) {
        super(message, cause, detail);
    }

    public NoValidDataException(Throwable cause, String detail) {
        super(cause, detail);
    }
}
