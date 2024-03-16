package org.torrentloom.utils.listserializer

import kotlinx.serialization.serializer
import org.torrentloom.utils.ArrayWrappingSerializer

object StringListSerializer : ArrayWrappingSerializer<String>(serializer<String>())
