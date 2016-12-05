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

        // TODO: why not to use map.compute?
        if (notes.containsKey(keyToAdd)) {
            def thisNumber = notes.get(keyToAdd)
            notes.put(keyToAdd, addNumber + (int) thisNumber)
        } else {
            notes.put(keyToAdd, addNumber)
        }

        // TODO: why not to use map.compute?
        if (currencyAmount.containsKey(addCurrency)) {
            def amountOne = currencyAmount.get(addCurrency)
            currencyAmount.put(addCurrency, amountOne + addValue * addNumber)
        } else {
            currencyAmount.put(addCurrency, addNumber * addValue)
        }
    }

    void pollNotes(Currency pollCurrency, int pollValue, int pollNumber) {
        BankNote keyToPoll = new BankNote(pollCurrency, pollValue)

        // TODO: why not to use map.compute?
        notes.put(keyToPoll, notes.get(keyToPoll) - pollNumber)

        if (notes.get(keyToPoll) == 0) {
            notes.remove(keyToPoll)
        }

        // TODO: why not to use map.compute?
        currencyAmount.put(pollCurrency, currencyAmount.get(pollCurrency) - pollNumber)
        if (currencyAmount.get(pollCurrency) == 0) {
            currencyAmount.remove(pollCurrency)
        }
    }

    int getNoteNumber(BankNote banknoteKey) {
        def numberToGet = notes.get(banknoteKey)
        //TODO: if numberToGet is null an Null pointer exception will be throw trying to make "int" from NULL ?
        return (Integer) numberToGet
    }

    int getCurrencyAmount(Currency currencyKey) {
        //TODO: if numberToGet is null an Null pointer exception will be throw trying to make "int" from NULL ?
        def amountToGet = currencyAmount.get(currencyKey)
        return (Integer) amountToGet
    }

    // TODO: not needed - groovy will generate a getter
    def getBanknotes() {
        return notes
    }
}


