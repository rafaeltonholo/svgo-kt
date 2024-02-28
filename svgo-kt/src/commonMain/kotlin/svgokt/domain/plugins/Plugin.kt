package svgokt.domain.plugins

import svgokt.GlobalOverrides
import svgokt.domain.XastRoot
import svgokt.domain.plugins.xast.visit

typealias PluginFn = (root: XastRoot, params: PluginParams, info: PluginInfo) -> Visitor?

interface PluginParams : Map<String, Any> {
    companion object {
        internal operator fun invoke(params: Map<String, Any>): PluginParams =
            object : PluginParams, Map<String, Any> by params {}
    }
}

object NoPluginParam : PluginParams, Map<String, Any> by emptyMap()

interface Plugin<T : PluginParams> {
    val name: String?
    val description: String?
    val params: T?
    val fn: PluginFn?
}

/**
 * Plugins engine.
 */
fun invokePlugins(
    ast: XastRoot,
    info: PluginInfo,
    plugins: List<Plugin<*>>,
    overrides: Map<String, Boolean>?, // not sure about this
    globalOverrides: GlobalOverrides, // Maybe should be Config instead? OR an implementation of it?
) {
    for (plugin in plugins) {
        val override = overrides?.get(plugin.name) ?: true // if null, should keep running.
        if (!override) {
            continue
        }

        val params = PluginParams(
            buildMap {
                plugin.params?.let { putAll(it) }
                putAll(globalOverrides.toMap())
                overrides?.let { putAll(overrides) }
            }
        )

        val fn = plugin.fn ?: error("Plugin function should not be null. Plugin name: ${plugin.name}")

        val visitor = fn(ast, params, info)
        if (visitor != null) {
            ast.visit(visitor = visitor)
        }
    }
}
