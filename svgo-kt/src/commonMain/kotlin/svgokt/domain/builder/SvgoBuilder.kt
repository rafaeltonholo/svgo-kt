package svgokt.domain.builder

import svgokt.Svgo
import svgokt.SvgoImpl
import svgokt.domain.Config

fun svgo(block: SvgoBuilder.() -> Unit): Svgo =
    SvgoBuilder().apply(block).build()

@DslMarker
annotation class SvgoDsl

@SvgoDsl
class SvgoBuilder {
    private var defaultConfig: Config? = null

    fun config(block: ConfigBuilder.() -> Unit) {
        defaultConfig = ConfigBuilder().apply(block).build()
    }

    fun build(): Svgo = SvgoImpl(
        defaultConfig = defaultConfig,
    )
}
