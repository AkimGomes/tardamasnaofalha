package br.com.mobile.tardamasnaofalha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.mobile.tardamasnaofalha.databinding.ActivityAdicionarBinding
import br.com.mobile.tardamasnaofalha.databinding.LoginBinding

class AdicionarActivity : DebugActivity() {

    private val binding by lazy {
        ActivityAdicionarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = "Adicionar Países"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.botaoSalvarPais.setOnClickListener {
            val p = Pais()
            p.nome = binding.paisNome.text.toString()
            p.capital = binding.capitalNome.text.toString()
            p.continente = binding.continenteNome.text.toString()
            p.populacao = binding.populacaoQuantidade.text.toString()
            p.latitude = binding.latitude.text.toString()
            p.longitude = binding.longitude.text.toString()
            p.bandeira = binding.bandeiraJPG.text.toString()

            Thread {
                PaisService.savePais(p)
                runOnUiThread{
                    finish()
                }
            }.start()

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