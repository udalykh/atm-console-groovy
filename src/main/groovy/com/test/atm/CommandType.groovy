package com.test.atm

enum CommandType {
    REMAININGS('?'),
    ADD('+'),
    WITHDRAW('-')

    private final String command

    CommandType(command) {
        this.command = command
    }

    public static CommandType getCommandType(String command) throws AtmStateException {
        for (CommandType commandTypeCheck : values()) {
            if (commandTypeCheck.command == command) {
                return commandTypeCheck
            }
        }
        throw new AtmStateException('UNIDENTIFIED COMMAND')
    }
}