package com.test.atm

import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable

@EqualsAndHashCode
@Sortable(includes = 'currency, value')
class BankNote {
    final Currency currency
    final int value

    BankNote(thisCurrency, thisValue) {
        currency = thisCurrency
        value = thisValue
    }
    boolean equals(Object o) {
        if (this == o) return true
        if (o == null || getClass() != o.getClass()) return false
        BankNote bankNoteCheck = (BankNote) o
        if (value != bankNoteCheck.value) return false
        return currency != null ? currency == bankNoteCheck.currency : bankNoteCheck.currency != null
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
