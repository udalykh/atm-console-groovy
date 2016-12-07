package com.test.atm

import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable

@EqualsAndHashCode
@Sortable(includes = 'currency, value')
class BankNote {
    private final Currency currency
    private final int value

    BankNote(thisCurrency, thisValue) {
        currency = thisCurrency
        value = thisValue
    }

    boolean equals(Object o) {
        if (this == o) return true
        if (!o || getClass() != o.getClass()) return false
        BankNote bankNoteCheck = (BankNote) o
        if (value != bankNoteCheck.value) return false
        return currency ? currency == bankNoteCheck.currency : bankNoteCheck.currency != null
    }

    int hashCode() {
        int result = currency ? currency.hashCode() : 0
        result = 128 * result + value
        return result
    }

    @Override
    String toString() {
        return "$currency $value"
    }
}
