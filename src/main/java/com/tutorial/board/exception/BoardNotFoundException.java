package com.tutorial.board.exception;

public class BoardNotFoundException extends BoardException {
    private static final long serialVesionUID = 1L;

    public BoardNotFoundException(String message) {
        super(message);
    }
}
