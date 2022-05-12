package io.rwwwx.footballmanagersystem.exception;

public class InvalidIdException extends RuntimeException {

    @Override
    public String getMessage() {
        return "invalid id, Player with this id may not exists";
    }

    @Override
    public String toString() {
        return "InvalidIdException";
    }

}
