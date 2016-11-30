package com.test.atm

enum Currency {
    CHF,
    EUR,
    JPY,
    RUR,
    USD

    static Currency getCurrency(String currencyForChecking) throws AtmStateException {
        values().each { it ->
            if (it.toString() == currencyForChecking) {
                return it
            }
        }
        throw new AtmStateException('ILLEGAL CURRENCY TYPE')
    }
}