package com.acensi.gineste.exception;

public class OutOfBoundException extends RuntimeException {
    public OutOfBoundException() {
        super("The rover cannot go over the mars length and heigh limits");
    }
}
