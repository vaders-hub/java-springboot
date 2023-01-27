package com.tutorial.board.exception;

public class BoardException extends RuntimeException {
    private static final long serialVesionUID = 1L;

    public BoardException(String message) {
        super(message);
    }
}
