package com.teachmeskills.lesson_14.validator;

import com.teachmeskills.lesson_14.exception.InvalidDocumentException;
import com.teachmeskills.lesson_14.util.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for processing documents,
 * validating them, and categorizing them into valid documents,
 * valid contracts, and invalid documents.
 * It reads documents from the specified file path,
 * validates each document, and writes the results to separate report files.
 */

public class DocumentProcessor {

    private final DocumentValidator documentValidator = new DocumentValidator();

    public void processDocuments(String filePath) throws IOException {
        List<String> documents = Files.readAllLines(Paths.get(filePath));

        List<String> validDocs = new ArrayList<>();
        List<String> validContracts = new ArrayList<>();
        List<String> invalidDocs = new ArrayList<>();

        for (String document : documents) {
            try {
                validateAndDocument(document, validDocs, validContracts);
            } catch (InvalidDocumentException e) {
                invalidDocs.add(document + " - " + e.getMessage() + " (Error Code: " + e.getErrorCode() + ")");
            }
        }

        writeReports(validDocs, validContracts, invalidDocs);
    }

    private void validateAndDocument(String document, List<String> validDocs, List<String> validContracts) throws InvalidDocumentException {
        documentValidator.validate(document);
        if (document.startsWith(Constants.DOCNUM_PREFIX)) {
            validDocs.add(document);
        } else if (document.startsWith(Constants.CONTRACT_PREFIX)) {
            validContracts.add(document);
        }
    }

    private void writeReports(List<String> validDocs, List<String> validContracts, List<String> invalidDocs) throws IOException {
        Files.write(Paths.get(Constants.VALID_DOC_REPORT_PATH), validDocs);
        Files.write(Paths.get(Constants.VALID_CONTRACT_REPORT_PATH), validContracts);
        Files.write(Paths.get(Constants.INVALID_DOC_REPORT_PATH), invalidDocs);
    }
}