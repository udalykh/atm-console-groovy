package com.test.atm

enum CommandType {
    REMAININGS('?'),
    ADD('+'),
    WITHDRAW('-')

    private final String command

    CommandType(command) {
        this.command = command
    }


    static CommandType getCommandType(String command) {
        try {
            return values().find { it.command == command }
        }
        catch (NullPointerException e) {
            throw new AtmStateException('UNIDENTIFIED COMMAND')
        }
    }
}
