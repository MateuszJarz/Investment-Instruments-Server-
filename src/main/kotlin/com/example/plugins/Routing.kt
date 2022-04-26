package com.example.plugins

import com.example.routes.getAllInstruments
import com.example.routes.root
import com.example.routes.searchInstruments
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.routing.*


fun Application.configureRouting() {

    routing {
        root()
        getAllInstruments()
        searchInstruments()
        static("/image") {
            resource("images")
        }
    }
}
