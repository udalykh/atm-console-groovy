package com.test.atm

/**
 * Created by Test on 12/07/2016.
 */
class CommandTypeTest extends GroovyTestCase {

    public void testAtmCommand() {
        CommandType addCheck = CommandType.getCommandType('+')
        assertEquals(addCheck, CommandType.ADD)

        CommandType withdrawalCheck = CommandType.getCommandType('-')
        assertEquals(withdrawalCheck, CommandType.WITHDRAW)

        CommandType remainCheck = CommandType.getCommandType('?')
        assertEquals(remainCheck, CommandType.REMAININGS)
    }
}
