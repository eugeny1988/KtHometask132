import org.junit.Test

import org.junit.Assert.*
import kotlin.test.assertIs

class MainKtTest {

    @Test
    fun commission() {
        val sendersAccount = "MasterCard"
        val recipientsAccount = "Maestro"
        val expectedValue = 12019.999999999998
        val realCommission = commission(sendersAccount, recipientsAccount)
        assertEquals(expectedValue, realCommission, 0.1)

    }
    @Test
    fun commissionVKTrue(){
        val recipientsAccount = "VK Pay"
        val sendersAccount = "Visa"
        val expectedValue = 0.00
        val realValue = commission(recipientsAccount,sendersAccount)
       assertEquals(expectedValue,realValue,0.00001)
    }
    @Test
    fun commissionVKFalse(){



    }
    @Test
    fun commissionVKPay(){
        val recipientsAccount = "VK Pay"
        val sendersAccount = "Maestro"
        val expectedValue = commission(recipientsAccount,sendersAccount)
        assertEquals(expectedValue,0.00,0.0000001)
    }
    @Test
    fun commissionMasterCard(){
        val recipientsAccount = "MasterCard"
        val sendersAccount = "Maestro"
        val expectedValue = commission(recipientsAccount,sendersAccount)
        assertEquals(expectedValue,masterCardCommission(pay),0.0000001)
    }
    @Test
    fun commissionVisa(){
        val recipientsAccount = "Visa"
        val sendersAccount = "VK Pay"
        val expectedValue = 15.00
        val realValue = commission(recipientsAccount,sendersAccount)
        assertEquals(expectedValue, realValue,0.00000001)
    }

    @Test
    fun masterCardCommission() {
        val pay = 30.00
        val monthlyPayment = 0.00
        val expectedValue = 0.00
        val realValue = masterCardCommission(pay, monthlyPayment)
        assertEquals(expectedValue, realValue, 0.01)
    }

    @Test
    fun visaMirPayment() {
        val pay = 100.00
        val expectedValue = 35.00
        val realValue = visaMirPayment(pay)
        assertEquals(expectedValue, realValue, 0.1)
    }


}