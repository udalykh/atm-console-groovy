package com.test.atm

/**
 * Created by Test on 12/08/2016.
 */
class CommandFactoryTest extends GroovyTestCase {
    private MoneyStorage moneyStorage = new MoneyStorage()
    private AtmCommandFactory atmCommandFactory

    void setUp() {
        atmCommandFactory = new AtmCommandFactory(moneyStorage)
    }

    void testDefaultAtmCommand() {
        shouldFail(AtmStateException) {
            atmCommandFactory.create('ABC')
        }
    }
}
