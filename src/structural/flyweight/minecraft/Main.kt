package structural.flyweight.minecraft

fun main(args: Array<String>) {
    val world = World()
    for (i in 0 until 100) {
        val blockType = BlockFactory.createBlockType("Grass", "grass_texture.png", "Green")
        val block = Block(blockType, Pair(i, i*2))
        world.addBlock(block)
    }
    world.render()
}