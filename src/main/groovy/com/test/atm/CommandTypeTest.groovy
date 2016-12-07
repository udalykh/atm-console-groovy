package com.test.atm

/**
 * Created by Test on 12/07/2016.
 */
class CommandTypeTest extends GroovyTestCase{

    @Test
    public void testAtmCommand() throws AtmStateException {
        CommandType addCheck = CommandType.getCommandType("+")
        Assert.assertEquals(addCheck, CommandType.ADD)

        CommandType withdrawalCheck = CommandType.getCommandType("-")
        Assert.assertEquals(withdrawalCheck, CommandType.WITHDRAW)

        CommandType remainCheck = CommandType.getCommandType("?")
        Assert.assertEquals(remainCheck, CommandType.REMAININGS)
    }
}
