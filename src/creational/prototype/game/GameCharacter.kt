package creational.prototype.game

class GameCharacter(
    var id: String, var name: String,
    var level: Int,
    var weapon: String,
    val inventory: ArrayList<String>
) : Copyable {

    override fun clone(): Any {

        return GameCharacter(this.id, this.name, this.level, this.weapon, inventory)
    }

    override fun toString(): String {
        return "GameCharacter(id='$id', name='$name', level=$level, weapon='$weapon')"
    }

}