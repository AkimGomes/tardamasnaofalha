package br.com.mobile.tardamasnaofalha

import android.provider.DocumentsContract.Root
import androidx.room.Room

object DatabaseManager {

    private var dbInstance: TARDADatabase

    init {
        val contexto = TardaMasNaoFalhaApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            contexto,
            TARDADatabase::class.java,
            "tarda.sqlite"
        ).build()
    }

    fun getPaisDAO(): PaisDAO {
        return dbInstance.paisDAO()
    }
}