package structural.adapter.with_database

interface Database {
    fun insert(obj: Any): Boolean
    fun update(obj: Any): Boolean
    fun delete(obj: Any): Boolean
    fun get(obj: Any): Any?
}