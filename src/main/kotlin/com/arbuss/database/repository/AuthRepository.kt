package com.arbuss.database.repository

import com.arbuss.database.entity.User
import com.arbuss.database.insertOrUpdate
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

object AuthRepository {
    fun register(username: String, password: String) {
        transaction {
//            User.insertOrUpdate(username, password)

//            User.insert {
//                it[this.username] = username
//                it[this.password] = password
//            }

            User.insertOrUpdate(User.username) {
                it[this.username] = username
                it[this.password] = password
            }
        }
    }
}