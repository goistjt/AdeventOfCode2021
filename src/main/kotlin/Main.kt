import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.arguments.argument
import java.io.File

class AdventOfCode : CliktCommand() {
    override fun run() = Unit
}

class DayOneA: CliktCommand(help = "Calculate the number of inputs greater than the previous input") {
    val fileName by argument()

    override fun run() {
        val fileContents = File(fileName).readLines().map { it.toInt() }

        var increases = 0
        var previousInput = Int.MAX_VALUE
        fileContents.forEach {
            if ( it > previousInput) {
                increases +=1
            }

            previousInput = it
        }

        echo(increases)
    }
}

fun main(args: Array<String>) {
    AdventOfCode().subcommands(DayOneA()).main(args)
}