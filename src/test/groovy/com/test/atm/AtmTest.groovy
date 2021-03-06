package com.test.atm

/**
 * Created by Test on 12/07/2016.
 */
class AtmTest extends GroovyTestCase {
    private Atm atm
    def atmTest = [:] as TreeMap

    void setUp() {
        atm = new Atm()
    }

    void testSampleSession() {
        Map<BankNote, Integer> result = atm.runCommand("?")
        assertEquals(atmTest, result)

        result = atm.runCommand("+", "USD", "100", "30")
        atmTest = [(new BankNote(Currency.USD, 100)): 30]
        assertEquals(atmTest, result)

        try {
            atm.runCommand("+", "RUR", "250", "10")
            fail()
        } catch (AtmStateException e) {
        }

        result = atm.runCommand("+", "CHF", "100", "5")
        atmTest = [(new BankNote(Currency.CHF, 100)): 5]
        assertEquals(atmTest, result)

        result = atm.runCommand("+", "USD", "10", "50")
        atmTest = [(new BankNote(Currency.USD, 10)): 50]
        assertEquals(atmTest, result)

        result = atm.runCommand("?")
        atmTest =
                [(new BankNote(Currency.USD, 10)) : 50,
                 (new BankNote(Currency.CHF, 100)): 5,
                 (new BankNote(Currency.USD, 100)): 30]
        assertEquals(atmTest, result)

        result = atm.runCommand("-", "USD", "120")
        atmTest = [(new BankNote(Currency.USD, 100)): 1,
                   (new BankNote(Currency.USD, 10)) : 2]
        assertEquals(atmTest, result)

        try {
            atm.runCommand("-", "RUR", "500")
            fail()
        } catch (AtmStateException e) {
        }

        try {
            atm.runCommand("-", "CHF", "250")
            fail()
        } catch (AtmStateException e) {
        }

        result = atm.runCommand("?")
        atmTest = [(new BankNote(Currency.CHF, 100)): 5,
                   (new BankNote(Currency.USD, 10)) : 48,
                   (new BankNote(Currency.USD, 100)): 29]
        assertEquals(atmTest, result)

        try {
            atm.runCommand("+", "eur", "100", "5")
            fail()
        } catch (AtmStateException e) {
        }

        result = atm.runCommand("-", "CHF", "400")
        atmTest = [(new BankNote(Currency.CHF, 100)): 4]
        assertEquals(atmTest, result)

        result = atm.runCommand("+", "CHF", "10", "50")
        atmTest = [(new BankNote(Currency.CHF, 10)): 50]
        assertEquals(atmTest, result)

        result = atm.runCommand("?")
        atmTest = [(new BankNote(Currency.CHF, 10)) : 50,
                   (new BankNote(Currency.CHF, 100)): 1,
                   (new BankNote(Currency.USD, 10)) : 48,
                   (new BankNote(Currency.USD, 100)): 29]
        assertEquals(atmTest, result)

        result = atm.runCommand("-", "CHF", "200")
        atmTest = [(new BankNote(Currency.CHF, 100)): 1,
                   (new BankNote(Currency.CHF, 10)) : 10]
        assertEquals(atmTest, result)
    }
}
