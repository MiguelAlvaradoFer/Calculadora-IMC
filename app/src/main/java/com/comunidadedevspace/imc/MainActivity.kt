package com.comunidadedevspace.imc

import android.icu.text.TimeZoneFormat.TimeType
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar os componentes EditText
        // Criar uma variavel e associar o componente de UI<EditText>
        // Recuperar o botão

        val edtpeso  = findViewById<TextInputEditText>(R.id.edittext_peso)
        val edtaltura = findViewById<TextInputEditText>(R.id.edittext_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)



        btnCalcular.setOnClickListener {


            val pesoSTR: String= edtpeso.text.toString()
            val alturaSTR: String = edtaltura.text.toString()

            if (pesoSTR == "" || alturaSTR == ""){

                Snackbar.make(
                    edtpeso,
                    "preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()

           } else {
                val peso = pesoSTR.toFloat()
                val altura alturaSTR.toFloat()

                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2
                println("Ação do botão " + resultado)

            }
        }
    }
}