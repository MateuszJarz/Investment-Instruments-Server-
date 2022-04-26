package com.example.repository

import com.example.modeles.ApiResponse
import com.example.modeles.Instrument
const val NEXT_PAGE_KEY = "nextPage"
const val PREVIOUS_PAGE_KEY = "prevPage"

class InstrumentRepositoryImpl : InstrumentRepository {
    override val instruments: Map<Int, List<Instrument>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5,
        )
    }

    // Gold Silver
    override val page1 = listOf(
        Instrument(
            id = 1,
            image ="",
            about ="",
            rating = 0.0,
            family = listOf(
            )
        )
    )

    override val page2 = listOf(
        Instrument(
            id = 1,
            image ="",
            about ="",
            rating = 0.0,
            family = listOf()
        )
    )
    override val page3 = listOf(
        Instrument(
            id = 1,
            image ="",
            about ="",
            rating = 0.0,
            family = listOf()
        )
    )
    override val page4 = listOf(
        Instrument(
            id = 1,
            image ="",
            about ="",
            rating = 0.0,
            family = listOf()
        )
    )
    override val page5 = listOf(
        Instrument(
            id = 1,
            image ="",
            about ="",
            rating = 0.0,
            family = listOf()
        )
    )

    override suspend fun getAllInstruments(page: Int): ApiResponse {
        return  ApiResponse(
            success = true,
            message = "ok",
            prevPage = calculatePage(page = page)[PREVIOUS_PAGE_KEY],
            nextPage = calculatePage(page = page)[NEXT_PAGE_KEY] ,
            heroes = instruments[page]!!,
            lastUpdated = System.currentTimeMillis()
        )
    }

    private fun calculatePage(page: Int): Map<String,Int?>{
        var prevPage: Int? = page
        var nextPage: Int? = page
        if(page in 1..4){
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5){
            prevPage = prevPage?.minus(1)
        }
        if (page == 1){
            prevPage = null
        }
        if (page == 5){
            nextPage = null
        }

        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }

    override suspend fun searchInstruments(name: String?): ApiResponse {
        TODO("Not yet implemented")
    }


}