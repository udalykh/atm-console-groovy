package com.test.atm

/**
 * Created by Test on 12/07/2016.
 */
class MoneyStorageTest extends GroovyTestCase {
    private MoneyStorage moneyStorage

    void setUp() {
        moneyStorage = new MoneyStorage()
    }

    void testMoneyStorage() {
        def storageCheck = [:] as TreeMap
        moneyStorage.addNotes(Currency.USD, 100, 1)
        moneyStorage.addNotes(Currency.USD, 100, 2)
        storageCheck.put(new BankNote(Currency.USD, 100), 3)
        assertEquals(storageCheck, moneyStorage.getNotes())
    }

    void testMoneyStorage2() {
        shouldFail(AtmStateException) {
            moneyStorage.addNotes(Currency.RUR, 120, 1)
        }
    }

    void testNoteNumberException() {
        shouldFail(AtmStateException) {
            moneyStorage.getNoteNumber(new BankNote(Currency.USD, 10))
        }
    }

    void testCurrencyAmountException() {
        shouldFail(AtmStateException) {
            moneyStorage.getCurrencyAmount(Currency.JPY)
        }
    }
}
