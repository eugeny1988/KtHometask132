import org.junit.Test

import org.junit.Assert.*
import kotlin.test.assertIs

class MainKtTest {

    @Test
    fun commission() {
        val sendersAccount = "MasterCard"
        val recipientsAccount = "Maestro"
        val expectedValue = 10
        val realCommission = commission(sendersAccount, recipientsAccount)
        assertEquals(expectedValue, realCommission)
    }
    @Test
    fun commissionTestTrue(){
        val recipientsAccount = "Maestro"
        val vk = "VKPay"
        assertEquals(recipientsAccount === vk, true)
    }
    @Test
    fun commissionTestFalse(){
        val recipientsAccount = "Maestro"
        val vk = "VKPay"
        assertEquals(recipientsAccount === vk, false)
    }

    @Test
    fun masterCardCommission() {
        val pay = 30.00
        val monthlyPayment = 0.00
        val expectedValue = 150.00
        val realValue = masterCardCommission(pay,monthlyPayment)
        assertEquals(expectedValue,realValue)
    }

    @Test
    fun visaMirPayment() {
        val pay = 100.00
        val expectedValue = 100.00
        val realValue = visaMirPayment(pay)
        assertEquals(expectedValue, realValue)
    }


}