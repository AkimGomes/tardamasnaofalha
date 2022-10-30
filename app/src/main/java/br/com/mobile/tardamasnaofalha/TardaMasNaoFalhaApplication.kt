package br.com.mobile.tardamasnaofalha

import android.app.Application

class TardaMasNaoFalhaApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: TardaMasNaoFalhaApplication? = null

        fun getInstance(): TardaMasNaoFalhaApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no manifest")
            }
            return appInstance!!
        }
    }
}