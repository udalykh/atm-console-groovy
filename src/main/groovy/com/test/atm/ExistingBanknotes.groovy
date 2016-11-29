package com.test.atm

class ExistingBanknotes {
    static def exBank = [] as TreeSet

    static {
        [
                USD: [100, 50, 20, 10, 5, 2, 1],
                RUR: [5000, 1000, 500, 100, 50, 10],
                CHF: [1000, 200, 100, 50, 20, 10],
                JPY: [10000, 5000, 1000],
                EUR: [500, 200, 100, 50, 20, 10, 5]
        ].each {
            it, i ->
                it.each {
                    currency, values ->
                        values.each {
                            value ->
                                exBank.add(new BankNote(currency, value))
                        }
                }
        }
    }

    static void assertBanknote(assertCurrency, assertValue) throws AtmStateException {
        if (!exBank.contains(new BankNote(assertCurrency, assertValue))) {
            throw new AtmStateException("NOT EXISTING BANKNOTE")
        }
    }

    static Set<BankNote> getExistingBanknotes() {
        return exBank
    }
}
