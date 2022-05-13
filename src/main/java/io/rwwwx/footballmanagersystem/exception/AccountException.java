package io.rwwwx.footballmanagersystem.exception;

public class AccountException extends RuntimeException {

    @Override
    public String getMessage() {
        return "not enough money on account for transfer";
    }

    @Override
    public String toString() {
        return "AccountException";
    }
}
