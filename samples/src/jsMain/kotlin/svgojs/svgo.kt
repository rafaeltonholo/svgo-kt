//@file:OptIn(ExperimentalJsExport::class)
//
//package svgojs
//
//external val svgojs: SvgoJs = definedExternally
//
//@JsName("svgo")
//external interface SvgoJs {
//    fun optimize(input: String, config: SvgoJsConfig = definedExternally): SvgoJsOutput
//}
//
//@JsExport
//external class SvgoJsConfig {
//    /** Can be used by plugins, for example prefixids */
//    val path: String? = definedExternally
//
//    /** Pass over SVGs multiple times to ensure all optimizations are applied. */
//    val multipass: Boolean? = definedExternally
//
//    /** Precision of floating point numbers. Will be passed to each plugin that supports this param. */
//    val floatPrecision: Int? = definedExternally
//
//    /**
//     * Plugins configuration
//     * ['preset-default'] is default
//     * Can also specify any builtin plugin
//     * ['sortAttrs', { name: 'prefixIds', params: { prefix: 'my-prefix' } }]
//     * Or custom
//     * [{ name: 'myPlugin', fn: () => ({}) }]
//     */
//    val plugins: Array<dynamic> = definedExternally
//
//    /** Options for rendering optimized SVG from AST. */
//    val js2svg: dynamic = definedExternally
//
//    /** Output as Data URI string. */
//    val datauri: dynamic = definedExternally
//}
//
//external interface SvgoJsOutput {
//    val data: String
//}
//
