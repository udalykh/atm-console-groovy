import com.test.atm.AtmCommandFactory
import com.test.atm.AtmStateException
import com.test.atm.MoneyStorage

/**
 * Created by Test on 12/08/2016.
 */
class CommandFactoryTest extends GroovyTestCase {
    private MoneyStorage moneyStorage = new MoneyStorage()
    private AtmCommandFactory atmCommandFactory

    void setUp() {
        atmCommandFactory = new AtmCommandFactory(moneyStorage)
    }

    void defaultAtmCommand() {
        shouldFail(AtmStateException) {
            atmCommandFactory.create('ABC')
        }
    }
}
