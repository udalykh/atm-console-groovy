import com.test.atm.AtmStateException
import com.test.atm.AtmUtils

/**
 * Created by Test on 12/08/2016.
 */
class UtilTests extends GroovyTestCase {
    void utilTestOne() {
        shouldFail(AtmStateException) {
            AtmUtils.parseInt('ABC', 'STRING IS NOT PARSABLE')
        }
    }

    void utilTestTwo() {
        shouldFail(AtmStateException) {
            String[] stringArray = ['One', 'Two']
            AtmUtils.assertLengthCheck(3, stringArray)
        }
    }
}
