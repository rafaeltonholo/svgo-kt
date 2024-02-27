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
            }
        }
    }



//    println(svgo)

    val (original, expected) = SvgResource.EntitySvg

    svgo.optimize(input = original)
    println("Optimize finished")
//        svgojs.optimize(input = original).data.also { println(it) }

    println("End of program")
}
