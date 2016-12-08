package com.test.atm

/**
 * Created by Test on 12/07/2016.
 */
class AtmTest extends GroovyTestCase {
    private Atm atm;
    private Map<BankNote, Integer> atmTest = new TreeMap<>();

    void setUp() {
        atm = new Atm()
    }

    void sampleSession() throws AtmStateException {
        Map<BankNote, Integer> result = atm.runCommand("?")
        assertEquals(atmTest, result)

        result = atm.runCommand("+", "USD", "100", "30")
        atmTest.put(new BankNote(Currency.USD, 100), 30)
        assertEquals(atmTest, result)

        try {
            atm.runCommand("+", "RUR", "250", "10")
        } catch (AtmStateException e) {
        }

        result = atm.runCommand("+", "CHF", "100", "5")
        atmTest.clear();
        atmTest.put(new BankNote(Currency.CHF, 100), 5)
        assertEquals(atmTest, result)

        result = atm.runCommand("+", "USD", "10", "50")
        atmTest.clear()
        atmTest.put(new BankNote(Currency.USD, 10), 50)
        assertEquals(atmTest, result)

        result = atm.runCommand("?")
        atmTest.clear()
        atmTest.put(new BankNote(Currency.USD, 10), 50)
        atmTest.put(new BankNote(Currency.CHF, 100), 5)
        atmTest.put(new BankNote(Currency.USD, 100), 30)
        assertEquals(atmTest, result)

        result = atm.runCommand("-", "USD", "120")
        atmTest.clear()
        atmTest.put(new BankNote(Currency.USD, 100), 1)
        atmTest.put(new BankNote(Currency.USD, 10), 2)
        assertEquals(atmTest, result)

        try {
            atm.runCommand("-", "RUR", "500")
        } catch (AtmStateException e) {
        }

        try {
            atm.runCommand("-", "CHF", "250")
        } catch (AtmStateException e) {
        }

        result = atm.runCommand("?")
        atmTest.clear()
        atmTest.put(new BankNote(Currency.CHF, 100), 5)
        atmTest.put(new BankNote(Currency.USD, 10), 48)
        atmTest.put(new BankNote(Currency.USD, 100), 29)
        assertEquals(atmTest, result)

        try {
            atm.runCommand("+", "eur", "100", "5")
        } catch (AtmStateException e) {
        }

        result = atm.runCommand("-", "CHF", "400")
        atmTest.clear()
        atmTest.put(new BankNote(Currency.CHF, 100), 4)
        assertEquals(atmTest, result)

        result = atm.runCommand("+", "CHF", "10", "50")
        atmTest.clear()
        atmTest.put(new BankNote(Currency.CHF, 10), 50)
        assertEquals(atmTest, result)

        result = atm.runCommand("?")
        atmTest.clear()
        atmTest.put(new BankNote(Currency.CHF, 10), 50)
        atmTest.put(new BankNote(Currency.CHF, 100), 1)
        atmTest.put(new BankNote(Currency.USD, 10), 48)
        atmTest.put(new BankNote(Currency.USD, 100), 29)
        assertEquals(atmTest, result)
    }
}
