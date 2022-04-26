package com.example.routes

import com.example.modeles.ApiResponse
import com.example.repository.InstrumentRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException


fun Route.getAllInstruments(){
    val instrumentRepository : InstrumentRepository by inject()

    get("/investment/instruments"){
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?:1
            require(page in 1..5)

            val  apiResponse = instrumentRepository.getAllInstruments(page = page)

            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK

            )
        }catch (e: NumberFormatException){
            call.respond(
                message =  ApiResponse(success = false, message = "Only Number Allowed."),
                status = HttpStatusCode.BadRequest
            )
        }catch (e: IllegalArgumentException){
            call. respond(
                message = ApiResponse(success = false, message = "Heroes not Found."),
                status = HttpStatusCode.NotFound
            )
        }
    }
}