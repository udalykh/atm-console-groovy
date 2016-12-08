import com.test.atm.AtmStateException
import com.test.atm.Currency

/**
 * Created by Test on 12/07/2016.
 */
class CurrencyTest extends GroovyTestCase {

    void currencyTest() {
        Currency getUsd = Currency.getCurrency('USD')
        assertEquals(getUsd, Currency.USD)

        Currency getEur = Currency.getCurrency('EUR')
        assertEquals(getEur, Currency.EUR)

        Currency getJpy = Currency.getCurrency('JPY')
        assertEquals(getJpy, Currency.JPY)

        Currency getRur = Currency.getCurrency('RUR')
        assertEquals(getRur, Currency.RUR)

        Currency getChf = Currency.getCurrency('CHF')
        assertEquals(getChf, Currency.CHF)
    }

    void testCurrencyException() {
        shouldFail(AtmStateException) {
            Currency.getCurrency('Abcde')
        }
    }

    void testCurrencyNull() {
        shouldFail(AtmStateException) {
            Currency.getCurrency(null)
        }
    }
}
