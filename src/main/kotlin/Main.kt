import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands

class AdventOfCode : CliktCommand() {
    override fun run() = Unit
}

fun main(args: Array<String>) {
    AdventOfCode()
        .subcommands(
            DayOneA(), DayOneB(),
            DayTwoA()
        )
        .main(args)
}