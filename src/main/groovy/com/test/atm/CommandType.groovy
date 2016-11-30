package com.test.atm

enum CommandType {
    REMAININGS("?"),
    ADD("+"),
    WITHDRAW("-")

    private final String command

    CommandType(String command) {
        this.command = command
    }

    public static CommandType getCommandType(String command) throws AtmStateException {
        for (def commandTypeCheck : values()) {
            if (commandTypeCheck.toString() == command) {
                return commandTypeCheck
            }
        }
        throw new AtmStateException('UNIDENTIFIED COMMAND')
    }
}