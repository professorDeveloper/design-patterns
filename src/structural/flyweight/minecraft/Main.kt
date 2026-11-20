package structural.flyweight.minecraft

fun main(args: Array<String>) {
    val world = World()
    world.addBlock(10, 22, BlockCategory.DIRT)
    world.addBlock(10, 22, BlockCategory.GRASS)
    world.addBlock(10, 22, BlockCategory.STONE)
    println(world.getBlocks()[0].equals(world.getBlocks()[1]))
}