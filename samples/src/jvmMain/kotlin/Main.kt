import svgokt.domain.EndOfLine
import svgokt.domain.builder.svgo
import svgokt.getPlatform

suspend fun main() {
    println("Current platform: ${getPlatform().name}")
    val svgo = svgo {
        config {
            floatPrecision = 2
            js2svg {
                eol = EndOfLine.LF
                indent = 2
                pretty = true
            }

//            plugin(RemoveDimensions)
        }
    }

    val (original, expected) = SvgResource.Styles

    val output = svgo.optimize(input = original)

    println("output = ${output.data}")
    println("expected = $expected")
    println("Expected == output -> ${output.data.trim() == expected}")
}
