package br.com.mobile.tardamasnaofalha

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [
    Pais::class
], version = 1)
abstract class TARDADatabase: RoomDatabase() {
    abstract fun paisDAO(): PaisDAO
}