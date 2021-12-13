import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import java.io.File

class DayThreeA : CliktCommand() {
    val fileName by argument()

    override fun run() {
        val bitStrings = File(fileName).readLines()
        val splitBitStrings = bitStrings.map { it.toList() }
        var gammaRate = byteArrayOf()
        for (i in 0 until splitBitStrings[0].size) {
            val bits = splitBitStrings.map { it[i] }
            val mostCommon = bits.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
            gammaRate += mostCommon.toString().toInt().toByte()
        }

        echo(gammaRate.contentToString())
        // 738234 = Gamma * ~Gamma
    }
}
