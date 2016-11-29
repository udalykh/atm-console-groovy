package com.test.atm

class DepositCommand implements AtmCommand {
    MoneyStorage moneyStorage;

    DepositCommand(MoneyStorage moneyStorage) {
        this.moneyStorage = moneyStorage
    }

    Map<BankNote, Integer> execute(String... arguments) throws AtmStateException {
        AtmUtils.assertLengthCheck(3, arguments)
        Currency currencyToPut = Currency.getCurrency(arguments[0])
        int valueToPut = AtmUtils.parseInt(arguments[1], "ILLEGAL TYPING OF VALUE")
        int numberToPut = AtmUtils.parseInt(arguments[2], "ILLEGAL TYPING OF NUMBER")

        moneyStorage.addNotes(currencyToPut, valueToPut, numberToPut)
        return Collections.singletonMap(new BankNote(currencyToPut, valueToPut), numberToPut)
    }
}
