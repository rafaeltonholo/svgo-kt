import kotlinx.coroutines.runBlocking
import svgokt.domain.builder.svgo
import svgokt.domain.EndOfLine
import svgokt.getPlatform

fun main(): Unit = runBlocking {
    println("Current platform: ${getPlatform().name}")
    val svgo = svgo {
        config {
            floatPrecision = 2
            js2svg {
                eol = EndOfLine.LF
                indent = 2
            }
        }
    }

    val (original, expected) = SvgResource.Simple

    svgo.optimize(input = original).also { println("output = $it") }
}
