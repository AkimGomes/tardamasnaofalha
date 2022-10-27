package br.com.mobile.tardamasnaofalha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import br.com.mobile.tardamasnaofalha.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : DebugActivity() {

    private val binding by lazy {
        ActivityTelaInicialBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val params = intent.extras

        val nome_usuario = params?.getString("nome_usuario")
        binding.mensagemTelaInicial.text = "Olá, $nome_usuario"

        supportActionBar?.title = "Países"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        val progressbar = findViewById<ProgressBar>(R.id.barraProgresso)

        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou em buscar!", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {
            binding.barraProgresso.visibility = View.VISIBLE
            var i = progressbar.progress

            Thread(Runnable {
                while (i < 100) {
                    i += 1
                }
                try {
                    Thread.sleep(10000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            progressbar.visibility = View.INVISIBLE

            }).start()


            Toast.makeText(this, "Clicou em atualizar!", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_adicionar) {
            val intent = Intent(this, AdicionarActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Clicou em adicionar!", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_sair) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Saiu com sucesso!", Toast.LENGTH_LONG).show()
        }
        return true
    }

}