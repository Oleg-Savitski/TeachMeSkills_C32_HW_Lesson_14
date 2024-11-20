package com.teachmeskills.lesson_14.exception;

/**
 * This exception is used to signal that a document
 * does not meet the expected criteria or validation standards.
 * It provides detailed information about the document that caused the error,
 * including the specific error code.
 */

public class InvalidDocumentException extends RuntimeException {
    private final String document;
    private final String errorCode;

    public InvalidDocumentException(String message, String document, String errorCode) {
        super(message);
        this.document = document;
        this.errorCode = errorCode;
    }

    public String getDocument() {
        return document;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return super.toString() +
                (document != null ? " [Document: " + document + "]" : "") +
                (errorCode != null ? " [Error Code: " + errorCode + "]" : "");
    }
}