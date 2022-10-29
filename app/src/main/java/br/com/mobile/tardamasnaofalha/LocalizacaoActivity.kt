package br.com.mobile.tardamasnaofalha

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem

class LocalizacaoActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localizacao)

        supportActionBar?.title = "Localização do País"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            val intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)
        }
        return true
    }
}