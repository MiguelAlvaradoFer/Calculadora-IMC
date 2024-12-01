package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificação = findViewById<TextView>(R.id.tv_classificaçao)

        tvResult.text = result.toString()

        var classificação: String? = null

        if(result <= 18.5f){classificação = "MAGREZA"}
        else if(result > 18.5f && result<= 24.9f){ classificação = "NORMAL" }
        else if(result > 25f && result<= 29.99f){classificação = "SOBREPESO"}
        else if(result > 30f && result<= 39.99f){classificação = "OBESIDADE"}
        else if(result > 40f){"OBESIDADE GRAVE"}

        tvClassificação.text = classificação
    }
}