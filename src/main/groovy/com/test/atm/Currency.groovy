package com.test.atm

enum Currency {
    CHF,
    EUR,
    JPY,
    RUR,
    USD

    static Currency getCurrency(String currencyForChecking) throws AtmStateException {
        try {
            for (Currency checking : values()) {
                if (checking == valueOf(currencyForChecking)) {
                    return checking
                }
            }
            throw new IllegalArgumentException()
        } catch (IllegalArgumentException e) {
            throw new AtmStateException('ILLEGAL CURRENCY TYPE')
        }
    }
}