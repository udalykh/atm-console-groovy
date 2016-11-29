package com.test.atm

class BankNote {
    Currency currency
    int value

    BankNote(thisCurrency, thisValue) {
        currency = thisCurrency
        value = thisValue
    }

    @Override
    boolean equals(Object o) {
        if (this == o) return true
        if (o == null || getClass() != o.getClass()) return false
        BankNote bankNoteCheck = (BankNote) o
        if (value != bankNoteCheck.value) return false
        return currency != null ? currency == bankNoteCheck.currency : bankNoteCheck.currency != null
    }

    @Override
    int hashCode() {
        int result = currency != null ? currency.hashCode() : 0
        result = 128 * result + value
        return result
    }

    Currency getCurrency() {
        return currency
    }

    int getValue() {
        return value
    }

    //@Override
    int compareTo(BankNote testBankNote) {
        if (currency == testBankNote.getCurrency()) {
            return Integer.compare(value, testBankNote.value)
        } else {
            return currency <=> testBankNote.getCurrency()
        }
    }

    @Override
    String toString() {
        return currency + " " + value
    }
}
