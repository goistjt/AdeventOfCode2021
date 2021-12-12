import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.arguments.argument
import java.io.File

class AdventOfCode : CliktCommand() {
    override fun run() = Unit
}

class DayOneA : CliktCommand(help = "Calculate the number of inputs greater than the previous input") {
    val fileName by argument()

    override fun run() {
        val fileContents = File(fileName).readLines().map { it.toInt() }

        var increases = 0
        var previousInput = Int.MAX_VALUE
        fileContents.forEach {
            if (it > previousInput) {
                increases += 1
            }

            previousInput = it
        }

        echo(increases)
    }
}

class DayOneB : CliktCommand(help = "Calculate the number of 3-number windows greater than the previous window") {
    val fileName by argument()

    override fun run() {
        val fileContents = File(fileName).readLines().map { it.toInt() }
        val windows = fileContents.windowed(size = 3, step = 1, partialWindows = true)
        val windowSums = windows.map { it.sum() }
        val increases = windowSums.foldIndexed(initial = 0) { index, acc, i ->  if (index == 0) acc else if (i > windowSums[index - 1]) acc + 1 else acc }
        echo(increases)
    }
}

fun main(args: Array<String>) {
    AdventOfCode().subcommands(DayOneA(), DayOneB()).main(args)
}