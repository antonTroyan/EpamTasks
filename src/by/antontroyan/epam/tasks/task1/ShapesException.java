package by.antontroyan.epam.tasks.task1;


public class ShapesException extends Exception {

    String detail;

    public ShapesException(String detail) {
        this.detail = detail;
    }

    public ShapesException(String message, String detail) {
        super(message);
        this.detail = detail;
    }

    public ShapesException(String message, Throwable cause, String detail) {
        super(message, cause);
        this.detail = detail;
    }

    public ShapesException(Throwable cause, String detail) {
        super(cause);
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ShapesException{" +
                "detail='" + detail + '\'' +
                '}';
    }
}
