import svgokt.domain.EndOfLine
import svgokt.domain.builder.svgo
import svgokt.domain.plugins.NoPluginParam
import svgokt.domain.plugins.Visitor
import svgokt.domain.plugins.VisitorNode
import svgokt.domain.plugins.builtin.RemoveDimensions
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

            plugin(name = "preset-default")

            plugin(RemoveDimensions)

            plugin<NoPluginParam> {
                name = "removeDimensions"
                description =
                    "removes width and height in presence of viewBox (opposite to removeViewBox, disable it first)"
                fn { _, _, _ ->
                    Visitor(
                        element = VisitorNode(
                            onEnter = { node, _ ->
                                if (node.name == "svg") {
                                    val widthKey = "width"
                                    val heightKey = "height"
                                    val viewBoxKey = "viewBox"
                                    with(node.attributes) {
                                        when {
                                            containsKey(viewBoxKey) -> {
                                                remove(widthKey)
                                                remove(heightKey)
                                            }

                                            containsKey(widthKey) && containsKey(heightKey) -> {
                                                val width = get(widthKey)?.toIntOrNull() ?: return@VisitorNode Unit
                                                val height = get(heightKey)?.toIntOrNull() ?: return@VisitorNode Unit
                                                put(viewBoxKey, "0 0 $width $height")
                                                remove(widthKey)
                                                remove(heightKey)
                                            }

                                            else -> Unit
                                        }
                                    }
                                }
                                Unit
                            }
                        )
                    )
                }
            }
        }
    }

    val (original, expected) = SvgResource.EntitySvg

    svgo.optimize(input = original).also { println("output = $it") }
}
