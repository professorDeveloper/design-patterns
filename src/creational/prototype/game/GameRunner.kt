package creational.prototype.game

fun main() {
    val character = GameCharacter("1", "Player1", 1, "AK-47")
    val characterFactory = CharacterFactory(character)
    val character2 = characterFactory.cloneCharacter()
    println(character2)
    println(character)
    character.name="Terrorist"
    println(character2)

}