package com.test.atm

/**
 * Created by Test on 12/08/2016.
 */
class UtilTests extends GroovyTestCase {
    void testUtilOne() {
        shouldFail(AtmStateException) {
            AtmUtils.parseInt('ABC', 'STRING IS NOT PARSABLE')
        }
    }

    void testUtilTwo() {
        shouldFail(AtmStateException) {
            String[] stringArray = ['One', 'Two']
            AtmUtils.assertLengthCheck(3, stringArray)
        }
    }
}

