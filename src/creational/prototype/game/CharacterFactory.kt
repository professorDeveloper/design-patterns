package creational.prototype.game

class CharacterFactory(private var character: GameCharacter) {
    fun setCharacter(character: GameCharacter) {
        this.character = character
    }

    fun cloneCharacter(): GameCharacter {
        return character.clone() as GameCharacter
    }
}
