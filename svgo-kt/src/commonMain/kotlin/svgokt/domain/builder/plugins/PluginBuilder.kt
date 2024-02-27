package svgokt.domain.builder.plugins

import svgokt.domain.plugins.Plugin
import svgokt.domain.plugins.PluginFn
import svgokt.domain.plugins.PluginParams

@DslMarker
annotation class PluginDsl

@PluginDsl
class PluginBuilder<T : PluginParams> {
    var name: String? = null
    var description: String? = null
    var params: T? = null
    private var fn: PluginFn? = null

    fun fn(fn: PluginFn) {
        this.fn = fn
    }

    fun build(): Plugin<T> = object : Plugin<T> {
        override val name: String? = this@PluginBuilder.name
        override val description: String? = this@PluginBuilder.description
        override val params: T? = this@PluginBuilder.params
        override val fn: PluginFn? = this@PluginBuilder.fn
    }
}

fun <T : PluginParams> plugin(block: PluginBuilder<T>.() -> Unit): Plugin<T> =
    PluginBuilder<T>().apply(block).build()
