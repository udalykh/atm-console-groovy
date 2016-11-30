package com.test.atm

class MoneyStorage {

    def notes = [:] as TreeMap
    def currencyAmount = [:]

    boolean hasNote(Currency hasCurrency, int hasValue) {
        return notes.containsKey(new BankNote(hasCurrency, hasValue))
    }

    boolean hasCurrency(Currency hasCurrency2) {
        return currencyAmount.containsKey(hasCurrency2)
    }

    void addNotes(Currency addCurrency, int addValue, int addNumber) throws AtmStateException {
        ExistingBanknotes.assertBanknote(addCurrency, addValue)
        BankNote keyToAdd = new BankNote(addCurrency, addValue)
        if (notes.containsKey(keyToAdd)) {
            def thisNumber = notes.get(keyToAdd)
            notes.put(keyToAdd, addNumber + (int) thisNumber)
        } else {
            notes.put(keyToAdd, addNumber)
        }
        if (currencyAmount.containsKey(addCurrency)) {
            def amountOne = currencyAmount.get(addCurrency)
            currencyAmount.put(addCurrency, amountOne + addValue * addNumber)
        } else {
            currencyAmount.put(addCurrency, addNumber * addValue)
        }
    }

    void pollNotes(Currency pollCurrency, int pollValue, int pollNumber) {
        BankNote keyToPoll = new BankNote(pollCurrency, pollValue)
        notes.put(keyToPoll, notes.get(keyToPoll) - pollNumber)
        if (notes.get(keyToPoll) == 0) {
            notes.remove(keyToPoll)
        }
        currencyAmount.put(pollCurrency, currencyAmount.get(pollCurrency) - pollNumber)
        if (currencyAmount.get(pollCurrency) == 0) {
            currencyAmount.remove(pollCurrency)
        }
    }

    int getNoteNumber(BankNote banknoteKey) {
        def numberToGet = notes.get(banknoteKey)
        return (Integer) numberToGet
    }

    int getCurrencyAmount(Currency currencyKey) {
        def amountToGet = currencyAmount.get(currencyKey)
        return (Integer) amountToGet
    }

    def getBanknotes() {
        return notes
    }
}


