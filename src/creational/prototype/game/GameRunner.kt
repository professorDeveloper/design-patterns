package creational.prototype.game

fun main() {
    val character = GameCharacter("1", "Player1", 1, "AK-47",arrayListOf("1","2"))
    val characterFactory = CharacterFactory(character)
    val character2 = characterFactory.cloneCharacter()
    println(character.inventory)
    println(character2.inventory)
    character.inventory.add("1")
    println(character.inventory)
    println(character2.inventory)



}