import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import java.io.File
import kotlin.experimental.inv

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


// Sourced from https://stackoverflow.com/a/50078501
/**
 * Returns a list of lists, each built from elements of all lists with the same indexes.
 * Output has length of shortest input list.
 */
private fun <T> zip(vararg lists: List<T>): List<List<T>> {
    return zip(*lists, transform = { it })
}

/**
 * Returns a list of values built from elements of all lists with same indexes using provided [transform].
 * Output has length of shortest input list.
 */
private inline fun <T, V> zip(vararg lists: List<T>, transform: (List<T>) -> V): List<V> {
    val minSize = lists.minOfOrNull(List<T>::size) ?: return emptyList()
    val list = ArrayList<V>(minSize)

    val iterators = lists.map { it.iterator() }
    var i = 0
    while (i < minSize) {
        list.add(transform(iterators.map { it.next() }))
        i++
    }

    return list
}