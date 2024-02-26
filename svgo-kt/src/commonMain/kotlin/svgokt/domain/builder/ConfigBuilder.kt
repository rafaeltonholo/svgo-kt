package svgokt.domain.builder

import svgokt.domain.Config
import svgokt.domain.DataUri
import svgokt.domain.StringifyOptions

fun config(block: ConfigBuilder.() -> Unit): Config =
    ConfigBuilder().apply(block).build()

@DslMarker
annotation class ConfigDsl

@ConfigDsl
class ConfigBuilder {
    var path: String? = null
    var multipass: Boolean = false
    var floatPrecision: Int? = null
    private var plugins: List<Any> = mutableListOf()
    private var js2svg: StringifyOptions? = null
    var dataUri: DataUri? = null

    fun js2svg(block: StringifyOptionsBuilder.() -> Unit) {
        js2svg = stringifyOptions(block)
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
