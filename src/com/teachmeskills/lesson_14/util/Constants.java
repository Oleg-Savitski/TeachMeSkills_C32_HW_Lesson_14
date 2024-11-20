package com.teachmeskills.lesson_14.util;

/** This interface defines prefixes for various document types,
 * document length, and paths to reports on valid and non-valid documents.
 */

public interface Constants {

    String DOCNUM_PREFIX = "docnum";
    String CONTRACT_PREFIX = "contract";
    int DOCUMENT_LENGTH = 15;

    String VALID_DOC_REPORT_PATH = "src/com/teachmeskills/lesson_14/resource/report/valid_docs_report.txt";
    String VALID_CONTRACT_REPORT_PATH = "src/com/teachmeskills/lesson_14/resource/report/valid_contracts_report.txt";
    String INVALID_DOC_REPORT_PATH = "src/com/teachmeskills/lesson_14/resource/report/invalid_docs_report.txt";

}
