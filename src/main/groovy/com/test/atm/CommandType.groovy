package com.test.atm

enum CommandType {
    REMAININGS('?'),
    ADD('+'),
    WITHDRAW('-')

    private final String command

    CommandType(command) {
        this.command = command
    }

    //TODO: let's throw AtmStateException if the command is incorrect
    static CommandType getCommandType(String command) {
        // TODO: refactor to Groovy style:
        // values().find { it.command == command }

        for (CommandType commandTypeCheck : values()) {
            if (commandTypeCheck.command == command) {
                return commandTypeCheck
            }
        }
        return null
    }
}
