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

        val nomeUsuario = Prefs.getString("nomeUsuario")
        val senhaUsuario = Prefs.getString("senhaUsuario")

        val checkLogin = Prefs.getBoolean("checkLogin")
        binding.Usuario.setText(nomeUsuario)
        binding.Senha.setText(senhaUsuario)
        binding.checkBoxLogin.isChecked = checkLogin


        binding.botaoLogin.setOnClickListener {

            val nome_usuario = binding.Usuario.text.toString()
            val senha_usuario = binding.Senha.text.toString()

            val checkLogin = binding.checkBoxLogin.isChecked
            if (checkLogin) {
                Prefs.setString("nomeUsuario", nome_usuario)
                Prefs.setString("senhaUsuario", senha_usuario)
            } else {
                Prefs.setString("nomeUsuario", "")
                Prefs.setString("senhaUsuario", "")
            }
            Prefs.setBoolean("checkLogin", checkLogin)

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