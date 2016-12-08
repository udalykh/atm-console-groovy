import com.test.atm.BankNote
import com.test.atm.Currency

/**
 * Created by Test on 12/07/2016.
 */
class BanknoteTest extends GroovyTestCase {
    void testBanknoteToString() {
        BankNote testBanknote = new BankNote(Currency.USD, 100)
        String expected = 'USD 100'
        assertEquals(testBanknote.toString(), expected)
    }
}
