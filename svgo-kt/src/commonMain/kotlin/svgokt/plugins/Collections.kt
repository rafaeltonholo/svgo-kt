package svgokt.plugins

private object ElementGroups {
    val animation = setOf(
        "animate",
        "animateColor",
        "animateMotion",
        "animateTransform",
        "set",
    )
    val descriptive = setOf("desc", "metadata", "title")
    val shape = setOf(
        "circle",
        "ellipse",
        "line",
        "path",
        "polygon",
        "polyline",
        "rect",
    )
    val structural = setOf("defs", "g", "svg", "symbol", "use")
    val paintServer = setOf(
        "hatch",
        "linearGradient",
        "meshGradient",
        "pattern",
        "radialGradient",
        "solidColor",
    )
    val nonRendering = setOf(
        "clipPath",
        "filter",
        "linearGradient",
        "marker",
        "mask",
        "pattern",
        "radialGradient",
        "solidColor",
        "symbol",
    )
    val container = setOf(
        "a",
        "defs",
        "foreignObject",
        "g",
        "marker",
        "mask",
        "missing-glyph",
        "pattern",
        "svg",
        "switch",
        "symbol",
    )
    val textContent = setOf(
        "altGlyph",
        "altGlyphDef",
        "altGlyphItem",
        "glyph",
        "glyphRef",
        "text",
        "textPath",
        "tref",
        "tspan",
    )
    val textContentChild = setOf("altGlyph", "textPath", "tref", "tspan")
    val lightSource = setOf(
        "feDiffuseLighting",
        "feDistantLight",
        "fePointLight",
        "feSpecularLighting",
        "feSpotLight",
    )
    val filterPrimitive = setOf(
        "feBlend",
        "feColorMatrix",
        "feComponentTransfer",
        "feComposite",
        "feConvolveMatrix",
        "feDiffuseLighting",
        "feDisplacementMap",
        "feDropShadow",
        "feFlood",
        "feFuncA",
        "feFuncB",
        "feFuncG",
        "feFuncR",
        "feGaussianBlur",
        "feImage",
        "feMerge",
        "feMergeNode",
        "feMorphology",
        "feOffset",
        "feSpecularLighting",
        "feTile",
        "feTurbulence",
    )
}

object Collections {
    val textElements: Set<String> = buildSet {
        addAll(ElementGroups.textContent)
        add("pre")
        add("title")
    }

    /**
     * @see https://www.w3.org/TR/SVG11/linking.html#processingIRI
     */
    val referencesProps = setOf(
        "clip-path",
        "color-profile",
        "fill",
        "filter",
        "marker-end",
        "marker-mid",
        "marker-start",
        "mask",
        "stroke",
        "style",
    )
}
