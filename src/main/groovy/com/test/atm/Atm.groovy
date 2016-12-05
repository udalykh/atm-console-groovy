package com.test.atm

class Atm {

    private static final String QUIT_WORD = 'QUIT'
    private static final String OK_WORD = 'OK'
    private static final String ERROR_WORD = 'ERROR'

    private AtmCommandFactory atmCommandFactory

    Atm() {
        MoneyStorage moneyStorage = new MoneyStorage()
        atmCommandFactory = new AtmCommandFactory(moneyStorage)
    }

    // in Groovy all exception are not checked so "throws AtmStateException" is nor needed
    Map<BankNote, Integer> runCommand(String command, String... arguments) throws AtmStateException {
        AtmCommand atmCommand = atmCommandFactory.create(command)
        // TODO: in Groovy "return" is not needed; can be just "atmCommand.execute(arguments)"
        return atmCommand.execute(arguments)
    }


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in)

        Atm atm = new Atm()
        while (true){
            // pass parameters from console to ATM
            try {
                final String input = scanner.nextLine()
                String[] lineToRead = input.split('\\s')
                String command = lineToRead[0]
                String[] arguments = Arrays.copyOfRange(lineToRead, 1, lineToRead.length)
                if (command.equalsIgnoreCase(QUIT_WORD)) {
                    System.exit(0)
                }

                Map<BankNote, Integer> response = atm.runCommand(command, arguments)
                response.entrySet().each { entry ->
                    println("$entry.key $entry.value")
                }
                println OK_WORD
            } catch (AtmStateException e) { // TODO: can be just "} catch (ignored)"
                println ERROR_WORD
            }
        }
    }
}
