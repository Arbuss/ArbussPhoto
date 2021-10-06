package com.arbuss.database.entity

import org.jetbrains.exposed.sql.*

object User: Table("user") {
    val username: Column<String> = varchar("username", 50)
    val password: Column<String> = varchar("password", 50)
    override val primaryKey = PrimaryKey(username)
}