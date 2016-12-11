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
        values().find { it.command == command }
    }
}
