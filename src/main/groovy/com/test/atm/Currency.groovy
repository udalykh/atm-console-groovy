package com.test.atm

enum Currency {
    CHF,
    EUR,
    JPY,
    RUR,
    USD

    static Currency getCurrency(String currencyForChecking) throws AtmStateException {
        for (Currency checking : values()) {
            if (checking == valueOf(currencyForChecking)) {
                return checking
            }
        }
        throw new AtmStateException('ILLEGAL CURRENCY TYPE')
    }
}