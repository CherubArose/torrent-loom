package org.torrentloom.utils.listserializer

import kotlinx.serialization.builtins.serializer
import org.torrentloom.utils.ArrayWrappingSerializer

object IntListSerializer : ArrayWrappingSerializer<Int>(Int.serializer())
