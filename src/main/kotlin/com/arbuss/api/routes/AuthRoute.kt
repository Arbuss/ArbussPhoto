package com.arbuss.api.routes

import com.arbuss.api.model.User
import com.arbuss.database.repository.AuthRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureAuthRouting() {
    routing {
        post("/register") {
            val user = call.receive<User>()
            AuthRepository.register(user.username, user.password)
            call.respondText("User Created", status = HttpStatusCode.Created)
        }
    }
}