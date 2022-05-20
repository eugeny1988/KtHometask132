val masterCard = "MasterCard"
val maestro = "Maestro"
val visa = "Visa"
val mir = "Мир"
val vk = "VK Pay"
val masterCardMaximum = 7000_000.00
val maxDailyPayment = 15_000_000.00
val maxMonthlyPayment = 60_000_000.00
val vkMaxDailyPayment = 1_500_000
val vkMaxMonthlyPayment = 4_000_000
val pay = 1000.00
val monthlyPayment = 100000.00
fun main() {
    if (!isLimit(masterCard, monthlyPayment, pay)) println("Вы превысили лимит")
    else println("Комиссия составит ${commission(masterCard, maestro, monthlyPayment, pay)}")
}

fun commission(
    sendersAccount: String,
    recipientsAccount: String,
    monthlyPayment: Double = 0.00,
    pay: Double
): Double {
    return if (recipientsAccount === vk) {
        0.00
    } else when (sendersAccount) {
        masterCard, maestro -> masterCardCommission(pay, monthlyPayment)
        visa, mir -> visaMirPayment(pay)
        else -> 0.00
    }
}

fun masterCardCommission(
    pay: Double,
    monthlyPayment: Double = 0.00
)
        : Double {
    return when (pay + monthlyPayment) {
        in 0.00..masterCardMaximum -> 0.00
        else -> 0.0006 * pay + 20
    }
}

fun visaMirPayment(pay: Double): Double {
    return if (pay > 35) 0.0075 * pay
    else 35.00
}

fun isLimit(
    sendersAccount: String,
    monthlyPayment: Double,
    dailyPayment: Double
): Boolean {
    return when (sendersAccount) {
        vk -> {
            if (dailyPayment < vkMaxDailyPayment || monthlyPayment < vkMaxMonthlyPayment) true
            else false
        }
        else -> {
            if (monthlyPayment < maxMonthlyPayment || dailyPayment < maxDailyPayment) true
            else false
        }
    }
}
