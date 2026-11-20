package structural.flyweight.minecraft

object BlockFactory {
    val blockTypes = mutableMapOf<String, BlockType>()

    @OptIn(ExperimentalStdlibApi::class)
    fun createBlockType(name: String, texture: String, color: String): BlockType {
        val key = "$name-$texture-$color"
        val blockType = blockTypes.getOrElseIfNull(key) {
            val newBlockType = BlockType(name, texture, color)
            blockTypes[key] = newBlockType
            newBlockType
        }
        return blockType
    }
}