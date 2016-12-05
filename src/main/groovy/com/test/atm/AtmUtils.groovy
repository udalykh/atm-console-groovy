package com.test.atm

class AtmUtils {
    // TODO: throws AtmStateException not needed
    static int parseInt(String stringToParse, String exceptionMessage) throws AtmStateException {
        try {
            // TODO: can be just "stringToParse as Integer" - no "return" is needed
            return Integer.parseInt(stringToParse)
        } catch (NumberFormatException e) {
            throw new AtmStateException(exceptionMessage)
        }
    }

    // TODO: throws AtmStateException not needed
    static void assertLengthCheck(int lengthCheck, String... stringArray) throws AtmStateException {
        if (stringArray.length != lengthCheck) {
            throw new AtmStateException('WRONG NUMBER OF PARAMETERS')
        }
    }
}
