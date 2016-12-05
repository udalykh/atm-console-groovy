package com.test.atm

import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable

// Good job with @Sortable!
@Sortable(includes = 'currency, value')
class BankNote {
    final Currency currency
    final int value

    BankNote(thisCurrency, thisValue) {
        currency = thisCurrency
        value = thisValue
    }

    // TODO: replace with @EqualsAndHashCode annotation
    @Override
    boolean equals(Object o) {
        if (this == o) return true
        if (o == null || getClass() != o.getClass()) return false
        BankNote bankNoteCheck = (BankNote) o
        if (value != bankNoteCheck.value) return false
        return currency != null ? currency == bankNoteCheck.currency : bankNoteCheck.currency != null
    }

    // TODO: replace with @EqualsAndHashCode annotation
    @Override
    int hashCode() {
        int result = currency ? currency.hashCode() : 0
        result = 128 * result + value
        return result
    }

    //TODO: not needed Groovy will create a getter under the hood
    Currency getCurrency() {
        return currency
    }

    //TODO: not needed Groovy will create a getter under the hood
    int getValue() {
        return value
    }

    @Override
    String toString() {
        return "$currency $value"
    }
}
