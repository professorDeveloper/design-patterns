package structural.flyweight.minecraft

class World {
    val blocks = arrayListOf<Block>()
    fun addBlock(x: Int, y: Int, category: BlockCategory) {
        val block = Block(BlockFactory.createBlockType(category), Pair(x, y))
        blocks.add(block)
    }

    fun getBlocks(): List<Block> {
        return blocks
    }

    fun render() {
        for (block in blocks) {
            println("Rendering block of type ${block.type.name} at coordinates ${block.coordinates}")
        }

    }
}