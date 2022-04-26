package com.example.di

import com.example.repository.InstrumentRepository
import com.example.repository.InstrumentRepositoryImpl
import org.koin.dsl.module
import kotlin.math.sin

val koinModule = module {
    single<InstrumentRepository> {
        InstrumentRepositoryImpl()
    }
}