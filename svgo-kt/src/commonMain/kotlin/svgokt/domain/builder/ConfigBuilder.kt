package svgokt.domain.builder

import svgokt.domain.Config
import svgokt.domain.DataUri
import svgokt.domain.StringifyOptions
import svgokt.domain.builder.plugins.PluginBuilder
import svgokt.domain.plugins.Plugin
import svgokt.domain.plugins.PluginParams
import kotlin.jvm.JvmName
import svgokt.domain.builder.plugins.plugin as pluginDsl

@DslMarker
annotation class ConfigDsl

@ConfigDsl
class ConfigBuilder {
    var path: String? = null
    var multipass: Boolean = false
    var floatPrecision: Int? = null
    private var plugins: MutableList<Any>? = null
    private var js2svg: StringifyOptions? = null
    var dataUri: DataUri? = null
    private val safePlugin: MutableList<Any>
        get() = plugins ?: mutableListOf<Any>().also {
            plugins = it
        }

    fun js2svg(block: StringifyOptionsBuilder.() -> Unit) {
        js2svg = stringifyOptions(block)
    }

    @JvmName("pluginFromString")
    fun plugin(name: String) {
        safePlugin += name
    }

    fun <T : PluginParams> plugin(block: PluginBuilder<T>.() -> Unit) {
        safePlugin += pluginDsl(block)
    }

    fun <T : PluginParams> plugin(name: String) {
        safePlugin += name
    }

    fun <T : PluginParams> plugin(plugin: Plugin<T>) {
        safePlugin += plugin
    }

    fun build(): Config = Config(
        path = path,
        multipass = multipass,
        floatPrecision = floatPrecision,
        plugins = plugins,
        js2svg = js2svg,
        dataUri = dataUri,
    )
}
