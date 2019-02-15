package com.richard.riddnote.Exception;

public class MarkdownsException extends RuntimeException {
    public MarkdownsException() {
    }

    public MarkdownsException(String message) {
        super(message);
    }

    public MarkdownsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkdownsException(Throwable cause) {
        super(cause);
    }
}
