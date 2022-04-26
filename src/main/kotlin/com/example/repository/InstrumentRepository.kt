package com.example.repository

import com.example.modeles.ApiResponse
import com.example.modeles.Instrument

interface InstrumentRepository {

    val instruments : Map<Int,List<Instrument>>

    val page1: List<Instrument>
    val page2: List<Instrument>
    val page3: List<Instrument>
    val page4: List<Instrument>
    val page5: List<Instrument>

    suspend fun getAllInstruments(page: Int = 1 ): ApiResponse
    suspend fun searchInstruments(name: String?): ApiResponse
}