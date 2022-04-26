package com.example.routes

import com.example.repository.InstrumentRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.searchInstruments(){

    val instrumentRepository : InstrumentRepository by inject()

    get("/investment/instruments/search"){
        val name = call.request.queryParameters["name"]

        val apiResponse = instrumentRepository.searchInstruments(name = name)
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )


    }
}