package svgokt.domain.plugins.builtin

import svgokt.domain.builder.plugins.plugin
import svgokt.domain.plugins.NoPluginParam
import svgokt.domain.plugins.VisitState
import svgokt.domain.plugins.Visitor
import svgokt.domain.plugins.VisitorNode

/**
 * Remove width/height attributes and add the viewBox attribute if it's missing
 *
 * @example
 * <svg width="100" height="50" />
 *   ↓
 * <svg viewBox="0 0 100 50" />
 *
 * @author Benny Schudel / parsed to Kotlin by Rafael Tonholo
 */
val RemoveDimensions = plugin<NoPluginParam> {
    name = "removeDimensions"
    description =
        "removes width and height in presence of viewBox (opposite to removeViewBox, disable it first)"
    fn { _, _, _ ->
        val onEnterSymbol = VisitState.Continue
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
                                    val width = get(widthKey)?.toIntOrNull() ?: return@VisitorNode onEnterSymbol
                                    val height = get(heightKey)?.toIntOrNull() ?: return@VisitorNode onEnterSymbol
                                    put(viewBoxKey, "0 0 $width $height")
                                    remove(widthKey)
                                    remove(heightKey)
                                }

                                else -> onEnterSymbol
                            }
                        }
                    }
                    onEnterSymbol
                }
            )
        )
    }
}
