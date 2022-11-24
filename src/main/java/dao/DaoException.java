package dao;

public class DaoException extends Exception {

    private static final long serialVersionUID = -8093755388375054066L;

    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
