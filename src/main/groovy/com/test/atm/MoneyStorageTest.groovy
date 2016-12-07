package com.test.atm

/**
 * Created by Test on 12/07/2016.
 */
class MoneyStorageTest extends GroovyTestCase {
    private MoneyStorage moneyStorage

    void setUp() {
        moneyStorage = new MoneyStorage()
    }

    void moneyStorageTest() throws AtmStateException {
        def storageCheck = [:] as TreeMap
        moneyStorage.addNotes(Currency.USD, 100, 1)
        moneyStorage.addNotes(Currency.USD, 100, 2)
        storageCheck.put(new BankNote(Currency.USD, 100), 3)
        assertEquals(storageCheck, moneyStorage.getNotes())
    }

    @Test(expected = AtmStateException.class)
    public void moneyStorageTest2() throws AtmStateException {
        moneyStorage.addNotes(Currency.RUR, 120, 1)
    }

    @Test(expected = AtmStateException.class)
    public void moneyStorageException() throws AtmStateException {
        moneyStorage.addNotes(Currency.USD, 10, 7)
        moneyStorage.getNoteNumber(new BankNote(Currency.USD, 10))
    }
}
