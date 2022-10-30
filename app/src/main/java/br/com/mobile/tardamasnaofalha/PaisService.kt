package br.com.mobile.tardamasnaofalha

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.net.URL

object PaisService {

    val host = "http://192.168.15.32:5000"
    val TAG = "TardaMasNaoFalha"

    fun getPaises(): List<Pais> {
        //var paises = mutableListOf<Pais>()
        try {
            val url = "$host/paises"
            val json = HttpHelper.get(url)

            var paises = parseJson<MutableList<Pais>>(json)

            Log.d(TAG, json)

            return paises
        } catch (ex: Exception) {
            var paises = DatabaseManager.getPaisDAO().findAll()
            return ArrayList<Pais>()
        }
    }

    fun savePais(pais: Pais) {
        if (AndroidUtils.isInternetDisponivel()) {
            val json = GsonBuilder().create().toJson(pais)
            HttpHelper.post("$host/paises", json)
        } else {
            DatabaseManager.getPaisDAO().insert(pais)
        }
    }

    fun deletePais(pais: Pais) {
        val url = "$host/pais/<int:id>"
        val json = HttpHelper.get(url)
        HttpHelper.delete(json)
    }

    inline fun <reified T> parseJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}