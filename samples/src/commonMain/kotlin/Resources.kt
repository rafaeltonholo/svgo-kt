object SvgResource {
    val Simple = """
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

    val EntitySvg = """
        |<?xml version="1.0" encoding="utf-8"?>
        |<!-- Generator: Adobe Illustrator 16.0.0, SVG Export Plug-In . SVG Version: 6.00 Build 0)  -->
        |<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd" [
        |<!ENTITY ns_extend "http://ns.adobe.com/Extensibility/1.0/">
        |<!ENTITY ns_ai "http://ns.adobe.com/AdobeIllustrator/10.0/">
        |<!ENTITY ns_graphs "http://ns.adobe.com/Graphs/1.0/">
        |<!ENTITY Viewport "<rect x='.5' y='.5' width='49' height='29'/>">
        |]>
        |<svg xmlns:x="&ns_extend;" xmlns:i="&ns_ai;" xmlns:graph="&ns_graphs;" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" width="583.029px" height="45px" viewBox="0 0 583.029 45" enable-background="new 0 0 583.029 45" xml:space="preserve">
        |  <g>
        |    &Viewport;
        |  </g>
        |</svg>
        |
        |@@@
        |
        |<?xml version="1.0" encoding="utf-8"?>
        |<!--Generator: Adobe Illustrator 16.0.0, SVG Export Plug-In . SVG Version: 6.00 Build 0)-->
        |<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd" [
        |<!ENTITY ns_extend "http://ns.adobe.com/Extensibility/1.0/">
        |<!ENTITY ns_ai "http://ns.adobe.com/AdobeIllustrator/10.0/">
        |<!ENTITY ns_graphs "http://ns.adobe.com/Graphs/1.0/">
        |<!ENTITY Viewport "<rect x='.5' y='.5' width='49' height='29'/>">
        |]>
        |<svg xmlns:x="http://ns.adobe.com/Extensibility/1.0/" xmlns:i="http://ns.adobe.com/AdobeIllustrator/10.0/" xmlns:graph="http://ns.adobe.com/Graphs/1.0/" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" width="583.029px" height="45px" viewBox="0 0 583.029 45" enable-background="new 0 0 583.029 45" xml:space="preserve">
        |    <g>
        |        <rect x=".5" y=".5" width="49" height="29"/>
        |    </g>
        |</svg>""".trimMargin().trim().split("\\s*@@@\\s*".toRegex())

    val Styles = """
        |<svg>
        |    <rect id="class" class="a"/>
        |    <rect id="two-classes" class="b a"/>
        |    <rect id="attribute" fill="purple"/>
        |    <rect id="inline-style" style="fill: grey;"/>
        |    <g fill="yellow">
        |        <rect id="inheritance"/>
        |        <g style="fill: blue;">
        |            <g>
        |                <rect id="nested-inheritance"/>
        |            </g>
        |        </g>
        |    </g>
        |    <style>
        |        .a { fill: red; }
        |    </style>
        |    <style>
        |        <![CDATA[
        |          .b { fill: green; stroke: black; }
        |        ]]>
        |    </style>
        |</svg>
        |
        |@@@
        |
        |<svg>
        |  <rect id="class" class="a"/>
        |  <rect id="two-classes" class="b a"/>
        |  <rect id="attribute" fill="purple"/>
        |  <rect id="inline-style" style="fill: grey;"/>
        |  <g fill="yellow">
        |    <rect id="inheritance"/>
        |    <g style="fill: blue;">
        |      <g>
        |        <rect id="nested-inheritance"/>
        |      </g>
        |    </g>
        |  </g>
        |  <style>
        |    <![CDATA[.a { fill: red; }
        |          .b { fill: green; stroke: black; }
        |        ]]>
        |  </style>
        |</svg>""".trimMargin().trim().split("\\s*@@@\\s*".toRegex())
}
