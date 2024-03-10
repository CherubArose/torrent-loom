package org.torrentloom.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonTransformingSerializer

/**
 * Serializer that transforms single value elements into lists.
 *
 * This helps with JSon formats that can contain either a single value or a list, they are always considered a list
 */
abstract class ArrayWrappingSerializer<T>(serializer: KSerializer<T>) :
    JsonTransformingSerializer<List<T>>(ListSerializer(serializer)) {
    override fun transformDeserialize(element: JsonElement): JsonElement =
        if (element !is JsonArray) JsonArray(listOf(element)) else element
}
