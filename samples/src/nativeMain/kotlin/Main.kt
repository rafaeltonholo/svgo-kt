import svgokt.domain.builder.svgo
import svgokt.domain.EndOfLine
import svgokt.getPlatform

fun main() {
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

    println(svgo)
}
