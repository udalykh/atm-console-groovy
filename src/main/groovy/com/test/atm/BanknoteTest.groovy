package com.test.atm

/**
 * Created by Test on 12/07/2016.
 */
class BanknoteTest extends GroovyTestCase {
    void testBanknoteToString() throws AtmStateException {
        BankNote testBanknote = new BankNote(Currency.USD, 100)
        String expected = "USD 100"
        assertEquals(testBanknote.toString(), expected)
    }
}
