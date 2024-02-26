package svgokt

import svgokt.domain.Config
import svgokt.domain.Output
import svgokt.domain.PluginInfo
import svgokt.parser.parseSvg

interface Svgo {
    suspend fun optimize(input: String, config: Config? = null): Output
}

internal class SvgoImpl(
    private val defaultConfig: Config?,
) : Svgo {

    override suspend fun optimize(input: String, config: Config?): Output {
        val overrideConfig = config ?: defaultConfig ?: Config()
        val maxPassCount = if (overrideConfig.multipass) 10 else 1
        var prevResultSize = Int.MAX_VALUE
        var output = ""
        var info = PluginInfo(
            path = overrideConfig.path,
            multipassCount = 0,
        )

        for (i in 0 until maxPassCount) {
            info = info.copy(multipassCount = i)
            println("Before parsing")
            val ast = parseSvg(data = input, from = overrideConfig.path)
            println("After parsing")
            println("ast=$ast")
        }

        return Output(
            data = "input", // TODO.
        )
    }

    override fun toString(): String = "Svgo(defaultConfig = $defaultConfig)"
}
