package com.arbuss

import com.arbuss.api.routes.configureAuthRouting
import com.arbuss.database.DatabaseHelper
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import com.arbuss.plugins.*
import io.ktor.application.*
import io.ktor.features.*

fun main() {
    DatabaseHelper.connect()
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        install(CallLogging)
        configureRouting()
        configureAuthRouting()
        configureSerialization()
    }.start(wait = true)
}
