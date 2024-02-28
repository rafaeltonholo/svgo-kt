package svgokt.plugins

import svgokt.GlobalOverrides
import svgokt.domain.XastRoot
import svgokt.domain.plugins.Plugin
import svgokt.domain.plugins.PluginInfo
import svgokt.domain.plugins.PluginParams
import svgokt.plugins.xast.visit

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
