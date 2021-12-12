import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import java.io.File

class DayTwoA : CliktCommand() {
    val fileName by argument()

    override fun run() {
        val vectors = File(fileName).readLines().map { it.split(" ") }
        var x = 0
        var y = 0
        vectors.forEach {
            val size = it[1].toInt()
            when(it[0]) {
                "forward" -> x += size
                "up" -> y -= size
                "down" -> y += size
            }
        }

        echo(x*y)
    }
}