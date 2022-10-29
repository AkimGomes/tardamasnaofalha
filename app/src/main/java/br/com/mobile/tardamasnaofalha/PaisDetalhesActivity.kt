package br.com.mobile.tardamasnaofalha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.mobile.tardamasnaofalha.databinding.ActivityPaisDetalhesBinding

class PaisDetalhesActivity : DebugActivity() {
    private val binding by lazy {
        ActivityPaisDetalhesBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = "Detalhes do País"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var nome = intent.extras?.getString("nome_pais")
        binding.nomePais.text = nome
        var capital = intent.extras?.getString("capital_pais")
        binding.capitalPais.text = capital
        var continente = intent.extras?.getString("continente_pais")
        binding.continentePais.text = continente
        var populacao = intent.extras?.getString("populacao_pais")
        binding.populacaoPais.text = populacao

        binding.botaoLocalizacao.setOnClickListener {
            val intent = Intent(this, LocalizacaoActivity::class.java)
            startActivity(intent)
        }

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