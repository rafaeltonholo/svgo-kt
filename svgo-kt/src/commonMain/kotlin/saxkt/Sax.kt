package saxkt

object Sax {
    val XmlEntities = mapOf(
        "amp" to '&'.code,
        "gt" to '>'.code,
        "lt" to '<'.code,
        "quot" to '"'.code,
        "apos" to '\''.code,
    )
    val Entities = buildMap {
        putAll(XmlEntities)
        put("AElig", 198)
        put("Aacute", 193)
        put("Acirc", 194)
        put("Agrave", 192)
        put("Aring", 197)
        put("Atilde", 195)
        put("Auml", 196)
        put("Ccedil", 199)
        put("ETH", 208)
        put("Eacute", 201)
        put("Ecirc", 202)
        put("Egrave", 200)
        put("Euml", 203)
        put("Iacute", 205)
        put("Icirc", 206)
        put("Igrave", 204)
        put("Iuml", 207)
        put("Ntilde", 209)
        put("Oacute", 211)
        put("Ocirc", 212)
        put("Ograve", 210)
        put("Oslash", 216)
        put("Otilde", 213)
        put("Ouml", 214)
        put("THORN", 222)
        put("Uacute", 218)
        put("Ucirc", 219)
        put("Ugrave", 217)
        put("Uuml", 220)
        put("Yacute", 221)
        put("aacute", 225)
        put("acirc", 226)
        put("aelig", 230)
        put("agrave", 224)
        put("aring", 229)
        put("atilde", 227)
        put("auml", 228)
        put("ccedil", 231)
        put("eacute", 233)
        put("ecirc", 234)
        put("egrave", 232)
        put("eth", 240)
        put("euml", 235)
        put("iacute", 237)
        put("icirc", 238)
        put("igrave", 236)
        put("iuml", 239)
        put("ntilde", 241)
        put("oacute", 243)
        put("ocirc", 244)
        put("ograve", 242)
        put("oslash", 248)
        put("otilde", 245)
        put("ouml", 246)
        put("szlig", 223)
        put("thorn", 254)
        put("uacute", 250)
        put("ucirc", 251)
        put("ugrave", 249)
        put("uuml", 252)
        put("yacute", 253)
        put("yuml", 255)
        put("copy", 169)
        put("reg", 174)
        put("nbsp", 160)
        put("iexcl", 161)
        put("cent", 162)
        put("pound", 163)
        put("curren", 164)
        put("yen", 165)
        put("brvbar", 166)
        put("sect", 167)
        put("uml", 168)
        put("ordf", 170)
        put("laquo", 171)
        put("not", 172)
        put("shy", 173)
        put("macr", 175)
        put("deg", 176)
        put("plusmn", 177)
        put("sup1", 185)
        put("sup2", 178)
        put("sup3", 179)
        put("acute", 180)
        put("micro", 181)
        put("para", 182)
        put("middot", 183)
        put("cedil", 184)
        put("ordm", 186)
        put("raquo", 187)
        put("frac14", 188)
        put("frac12", 189)
        put("frac34", 190)
        put("iquest", 191)
        put("times", 215)
        put("divide", 247)
        put("OElig", 338)
        put("oelig", 339)
        put("Scaron", 352)
        put("scaron", 353)
        put("Yuml", 376)
        put("fnof", 402)
        put("circ", 710)
        put("tilde", 732)
        put("Alpha", 913)
        put("Beta", 914)
        put("Gamma", 915)
        put("Delta", 916)
        put("Epsilon", 917)
        put("Zeta", 918)
        put("Eta", 919)
        put("Theta", 920)
        put("Iota", 921)
        put("Kappa", 922)
        put("Lambda", 923)
        put("Mu", 924)
        put("Nu", 925)
        put("Xi", 926)
        put("Omicron", 927)
        put("Pi", 928)
        put("Rho", 929)
        put("Sigma", 931)
        put("Tau", 932)
        put("Upsilon", 933)
        put("Phi", 934)
        put("Chi", 935)
        put("Psi", 936)
        put("Omega", 937)
        put("alpha", 945)
        put("beta", 946)
        put("gamma", 947)
        put("delta", 948)
        put("epsilon", 949)
        put("zeta", 950)
        put("eta", 951)
        put("theta", 952)
        put("iota", 953)
        put("kappa", 954)
        put("lambda", 955)
        put("mu", 956)
        put("nu", 957)
        put("xi", 958)
        put("omicron", 959)
        put("pi", 960)
        put("rho", 961)
        put("sigmaf", 962)
        put("sigma", 963)
        put("tau", 964)
        put("upsilon", 965)
        put("phi", 966)
        put("chi", 967)
        put("psi", 968)
        put("omega", 969)
        put("thetasym", 977)
        put("upsih", 978)
        put("piv", 982)
        put("ensp", 8194)
        put("emsp", 8195)
        put("thinsp", 8201)
        put("zwnj", 8204)
        put("zwj", 8205)
        put("lrm", 8206)
        put("rlm", 8207)
        put("ndash", 8211)
        put("mdash", 8212)
        put("lsquo", 8216)
        put("rsquo", 8217)
        put("sbquo", 8218)
        put("ldquo", 8220)
        put("rdquo", 8221)
        put("bdquo", 8222)
        put("dagger", 8224)
        put("Dagger", 8225)
        put("bull", 8226)
        put("hellip", 8230)
        put("permil", 8240)
        put("prime", 8242)
        put("Prime", 8243)
        put("lsaquo", 8249)
        put("rsaquo", 8250)
        put("oline", 8254)
        put("frasl", 8260)
        put("euro", 8364)
        put("image", 8465)
        put("weierp", 8472)
        put("real", 8476)
        put("trade", 8482)
        put("alefsym", 8501)
        put("larr", 8592)
        put("uarr", 8593)
        put("rarr", 8594)
        put("darr", 8595)
        put("harr", 8596)
        put("crarr", 8629)
        put("lArr", 8656)
        put("uArr", 8657)
        put("rArr", 8658)
        put("dArr", 8659)
        put("hArr", 8660)
        put("forall", 8704)
        put("part", 8706)
        put("exist", 8707)
        put("empty", 8709)
        put("nabla", 8711)
        put("isin", 8712)
        put("notin", 8713)
        put("ni", 8715)
        put("prod", 8719)
        put("sum", 8721)
        put("minus", 8722)
        put("lowast", 8727)
        put("radic", 8730)
        put("prop", 8733)
        put("infin", 8734)
        put("ang", 8736)
        put("and", 8743)
        put("or", 8744)
        put("cap", 8745)
        put("cup", 8746)
        put("int", 8747)
        put("there4", 8756)
        put("sim", 8764)
        put("cong", 8773)
        put("asymp", 8776)
        put("ne", 8800)
        put("equiv", 8801)
        put("le", 8804)
        put("ge", 8805)
        put("sub", 8834)
        put("sup", 8835)
        put("nsub", 8836)
        put("sube", 8838)
        put("supe", 8839)
        put("oplus", 8853)
        put("otimes", 8855)
        put("perp", 8869)
        put("sdot", 8901)
        put("lceil", 8968)
        put("rceil", 8969)
        put("lfloor", 8970)
        put("rfloor", 8971)
        put("lang", 9001)
        put("rang", 9002)
        put("loz", 9674)
        put("spades", 9824)
        put("clubs", 9827)
        put("hearts", 9829)
        put("diams", 9830)
    }

    // When we pass the MAX_BUFFER_LENGTH position, start checking for buffer overruns.
    // When we check, schedule the next check for MAX_BUFFER_LENGTH - (max(buffer lengths)),
    // since that's the earliest that a buffer overrun could occur.  This way, checks are
    // as rare as required, but as often as necessary to ensure never crossing this bound.
    // Furthermore, buffers are only tested at most once per write(), so passing a very
    // large string into write() might have undesirable effects, but this is manageable by
    // the caller, so it is assumed to be safe.  Thus, a call to write() may, in the extreme
    // edge case, result in creating at most one complete copy of the string passed in.
    // Set to Infinity to have unlimited buffers.
    val MaxBufferLength = 64 * 1024

    enum class State {
        BEGIN, // leading byte order mark or whitespace
        BEGIN_WHITESPACE, // leading whitespace
        TEXT, // general stuff
        TEXT_ENTITY, // &amp and such.
        OPEN_WAKA, // <
        SGML_DECL, // <!BLARG
        SGML_DECL_QUOTED, // <!BLARG foo "bar
        DOCTYPE, // <!DOCTYPE
        DOCTYPE_QUOTED, // <!DOCTYPE "//blah
        DOCTYPE_DTD, // <!DOCTYPE "//blah" [ ...
        DOCTYPE_DTD_QUOTED, // <!DOCTYPE "//blah" [ "foo
        COMMENT_STARTING, // <!-
        COMMENT, // <!--
        COMMENT_ENDING, // <!-- blah -
        COMMENT_ENDED, // <!-- blah --
        CDATA, // <![CDATA[ something
        CDATA_ENDING, // ]
        CDATA_ENDING_2, // ]]
        PROC_INST, // <?hi
        PROC_INST_BODY, // <?hi there
        PROC_INST_ENDING, // <?hi "there" ?
        OPEN_TAG, // <strong
        OPEN_TAG_SLASH, // <strong /
        ATTRIB, // <a
        ATTRIB_NAME, // <a foo
        ATTRIB_NAME_SAW_WHITE, // <a foo _
        ATTRIB_VALUE, // <a foo=
        ATTRIB_VALUE_QUOTED, // <a foo="bar
        ATTRIB_VALUE_CLOSED, // <a foo="bar"
        ATTRIB_VALUE_UNQUOTED, // <a foo=bar
        ATTRIB_VALUE_ENTITY_Q, // <foo bar="&quot;"
        ATTRIB_VALUE_ENTITY_U, // <foo bar=&quot
        CLOSE_TAG, // </a
        CLOSE_TAG_SAW_WHITE, // </a   >
        SCRIPT, // <script> ...
        SCRIPT_ENDING // <script> ... <
    }
}
