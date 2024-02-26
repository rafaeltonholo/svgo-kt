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

    val (original, expected) = """
        |<svg xmlns="http://www.w3.org/2000/svg">
        |    <g attr1="val1">
        |        <g attr2="val2">
        |            <path attr2="val3" d="..."/>
        |        </g>
        |        <path d="..."/>
        |    </g>
        |</svg>
        |
        |@@@
        |
        |<svg xmlns="http://www.w3.org/2000/svg">
        |  <g attr1="val1">
        |    <g attr2="val2">
        |      <path attr2="val3" d="..."/>
        |    </g>
        |    <path d="..."/>
        |  </g>
        |</svg>""".trimMargin().trim().split("\\s*@@@\\s*".toRegex())

    svgo.optimize(input = original)
    println("Optimize finished")
//        svgojs.optimize(input = original).data.also { println(it) }

    println("End of program")
}
