package com.arbuss.database

import com.arbuss.database.entity.User
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection

object DatabaseHelper {
    fun connect() {
        Database.connect("jdbc:sqlite:./arbussphotos", "org.sqlite.JDBC")
        transaction {
            SchemaUtils.create(User)
        }
        TransactionManager.manager.defaultIsolationLevel =
            Connection.TRANSACTION_SERIALIZABLE
    }
}