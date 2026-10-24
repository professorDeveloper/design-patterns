package structural.adapter.with_database

class DatabaseAdapter : JavaApplication(), Database {
    override fun insert(obj: Any): Boolean {
        println("Insert object...")
        super.insertObject(obj)
        return false
    }

    override fun update(obj: Any): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(obj: Any): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(obj: Any): Any? {
        TODO("Not yet implemented")
    }


}