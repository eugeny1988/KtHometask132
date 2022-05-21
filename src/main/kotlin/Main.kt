val masterCard = "MasterCard"
val maestro = "Maestro"
val visa = "Visa"
val mir = "Мир"
val vk = "VK Pay"
val masterCardMaximum = 7_000_000.00
val maxDailyPayment = 15_000_000.00
val maxMonthlyPayment = 60_000_000.00
val vkMaxDailyPayment = 1_500_000
val vkMaxMonthlyPayment = 4_000_000
val pay = 2000_000_0.00
val monthlyPayment = 0.00
val dailyPayment = 0.00
val account = masterCard
fun main() {
    if (!isLimit(account)) println("Вы превысили лимит")
    else println("Комиссия составит ${commission(account, maestro)}")
}

fun commission(
    sendersAccount: String,
    recipientsAccount: String,
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
    val visaMirCommission = 0.0075 * pay
    return if (visaMirCommission > 35) visaMirCommission
    else 35.00
}

fun isLimit(
    sendersAccount: String,
): Boolean {
    return when (sendersAccount) {
        "VK Pay" -> {
            dailyPayment + pay < vkMaxDailyPayment || monthlyPayment + pay < vkMaxMonthlyPayment
        }
        else -> {
            monthlyPayment + pay < maxMonthlyPayment || dailyPayment + pay < maxDailyPayment
        }
    }
}
