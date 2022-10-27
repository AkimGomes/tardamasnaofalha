package br.com.mobile.tardamasnaofalha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import br.com.mobile.tardamasnaofalha.databinding.LoginBinding

class MainActivity : DebugActivity() {

    private val binding by lazy {
        LoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.botaoLogin.setOnClickListener {

            val nome_usuario = binding.Usuario.text.toString()
            val senha_usuario = binding.Senha.text.toString()

            if (nome_usuario != "aluno") {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
            } else if (senha_usuario != "impacta") {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, TelaInicialActivity::class.java)
                Toast.makeText(this, "Seja bem-vindo", Toast.LENGTH_LONG).show()
                intent.putExtra("nome_usuario", nome_usuario)
                startActivity(intent)
            }

        }
    }
}