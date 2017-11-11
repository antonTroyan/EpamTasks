package by.troyan.epam.task3.exception;

public class FileNotExistExeption extends ShapesException {


    public FileNotExistExeption(String detail) {
        super(detail);
    }

    public FileNotExistExeption(String message, String detail) {
        super(message, detail);
    }

    public FileNotExistExeption(String message, Throwable cause, String detail) {
        super(message, cause, detail);
    }

    public FileNotExistExeption(Throwable cause, String detail) {
        super(cause, detail);
    }

    @Override
    public String toString() {
        return "FileNotExistExeption{}";
    }
}
