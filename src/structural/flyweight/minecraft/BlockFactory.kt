package structural.flyweight.minecraft

object BlockFactory {
    val blockTypesCache = mutableMapOf<String, BlockType>()

    fun createBlockType(category: BlockCategory): BlockType {
        return blockTypesCache.getOrPut(category.name) {
            BlockType(category.name, category.texture, category.color)
        }
    }
}