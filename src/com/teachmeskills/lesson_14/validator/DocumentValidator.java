package com.teachmeskills.lesson_14.validator;

import com.teachmeskills.lesson_14.exception.InvalidDocumentException;
import com.teachmeskills.lesson_14.util.Constants;

import java.util.regex.Pattern;

/**
 * The class is responsible for validating documents.
 * It checks whether documents meet the specified criteria,
 * including acceptable characters, format, and length.
 */

public class DocumentValidator {

    private static final Pattern VALIDATION_PATTERN = Pattern.compile("[a-zA-Z0-9]+");

    public void validate(String document) throws InvalidDocumentException {
        if (!VALIDATION_PATTERN.matcher(document).matches()) {
            throw new InvalidDocumentException("The document contains invalid characters.", document, "INVALID_CHAR");
        }

        if (!document.startsWith(Constants.DOCNUM_PREFIX) && !document.startsWith(Constants.CONTRACT_PREFIX)) {
            throw new InvalidDocumentException("Invalid document format.", document, "INVALID_FORMAT");
        }

        if (document.length() != Constants.DOCUMENT_LENGTH) {
            throw new InvalidDocumentException("Incorrect document length.", document, "INVALID_LENGTH");
        }
    }
}