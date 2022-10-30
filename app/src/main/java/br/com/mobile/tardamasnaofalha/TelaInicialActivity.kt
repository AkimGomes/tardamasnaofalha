package br.com.mobile.tardamasnaofalha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.mobile.tardamasnaofalha.databinding.ActivityTelaInicialBinding
import com.google.android.material.navigation.NavigationView

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val binding by lazy {
        ActivityTelaInicialBinding.inflate(layoutInflater)
    }

    private var paises = listOf<Pais>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val params = intent.extras

        supportActionBar?.title = "Países"

        configuraMenuLateral()

        binding.recyclerPaises?.layoutManager = LinearLayoutManager(this)
        binding.recyclerPaises?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        this.taskPaises()
    }

    private fun taskPaises() {
        Thread {
            paises = PaisService.getPaises()
            runOnUiThread {
                binding.recyclerPaises?.adapter = PaisAdapter(paises) {
                    onClickPais(it)
                }
            }
        }.start()
    }

    fun onClickPais(pais: Pais) {
        Toast.makeText(this, "Clicou no pais", Toast.LENGTH_LONG).show()

        var it = Intent(this, PaisDetalhesActivity::class.java)
        it.putExtra("nome_pais", pais.nome)
        it.putExtra("capital_pais", pais.capital)
        it.putExtra("continente_pais", pais.continente)
        it.putExtra("populacao_pais", pais.populacao)
        startActivity(it)
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_paises -> {
                val intent = Intent(this, TelaInicialActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Clicou em paises!", Toast.LENGTH_LONG).show()
            }
            R.id.nav_sobre -> {
                val intent = Intent(this, SobreActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Clicou em sobre!", Toast.LENGTH_LONG).show()
            }
            R.id.nav_sair -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Saiu com sucesso!", Toast.LENGTH_LONG).show()
            }
        }
        binding.layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }
    private fun configuraMenuLateral() {
        var toggle = ActionBarDrawerToggle(
            this,
            binding.layoutMenuLateral,
            R.string.abrir,
            R.string.fechar
        )
        binding.layoutMenuLateral.addDrawerListener(toggle)
        toggle.syncState()

        binding.menuLateral.setNavigationItemSelectedListener(this)
    }
}