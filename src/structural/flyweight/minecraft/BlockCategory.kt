package structural.flyweight.minecraft

enum class BlockCategory(val texture: String, val color: String) {
    GRASS(
        "grass_texture.png",
        "green"
    ),
    STONE("stone_texture.png", "gray"), DIRT("dirt_texture.png", "brown")
}