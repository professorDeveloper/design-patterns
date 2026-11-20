package structural.flyweight.minecraft

class World {
    val blocks = mutableListOf<Block>()
    fun addBlock(block: Block) {
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