package creational.prototype.game

class GameCharacter(
    var id: String, var name: String,
    var level: Int,
    var weapon: String,
    val inventory: ArrayList<String>
) : Copyable {

    override fun clone(): Any {
        val newList = ArrayList<String>()
        newList.addAll(inventory)
        return GameCharacter(this.id, this.name, this.level, this.weapon, newList)
    }

    override fun toString(): String {
        return "GameCharacter(id='$id', name='$name', level=$level, weapon='$weapon')"
    }

}