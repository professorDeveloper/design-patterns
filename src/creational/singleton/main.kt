package creational.singleton

import javax.xml.crypto.Data


fun main(args: Array<String>) {
    val logg = ProgrammingLogg.getInstance()
    val logg2 = ProgrammingLogg.getInstance()
    logg.showError("GG is wrong")
    logg2.log("two instances hashcodes: ${System.identityHashCode(logg)} | ${System.identityHashCode(logg2)}")


    val databaseHelper = DatabaseHelper.getInstance()

    databaseHelper.executeQuery("select * from instances limit 1")
}