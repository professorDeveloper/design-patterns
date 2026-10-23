package creational.singleton

import javax.xml.crypto.Data

class DatabaseHelper private constructor() {
    companion object {
        @Volatile
        private lateinit var databaseHelper: DatabaseHelper
        fun getInstance(): DatabaseHelper {
            synchronized(DatabaseHelper::class) {
                if (!::databaseHelper.isInitialized) {
                    databaseHelper = DatabaseHelper()
                }
                return databaseHelper
            }
        }
    }

    fun getData() {
        println("Get Data")
    }

    fun  executeQuery(query: String){
        println("Query successfully executed")
    }
}