package com.example.gadgetsfuture

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Editar_datos : AppCompatActivity() {

    private lateinit var txtNombre: EditText
    private lateinit var txtNum: EditText
    private lateinit var txtEmail: EditText
    private lateinit var nameError: TextView
    private lateinit var numError: TextView
    private lateinit var emailError: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_datos)

        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        txtNombre = findViewById(R.id.txtNombre)
        txtNum = findViewById(R.id.txtNum)
        txtEmail = findViewById(R.id.txtEmail)

        nameError = findViewById(R.id.nameError)
        numError = findViewById(R.id.numError)
        emailError = findViewById(R.id.emailError)

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        btnGuardar.setOnClickListener {
            validarCampos()
        }
    }

    private fun validarCampos() {
        val nombre = txtNombre.text.toString()
        val num = txtNum.text.toString()
        val email = txtEmail.text.toString()

        var isValid = true

        if (nombre.isEmpty()) {
            nameError.visibility = View.VISIBLE
            nameError.text = "El nombre no es válido"
            isValid = false
        } else {
            nameError.visibility = View.VISIBLE
            nameError.text = ""
        }

        if (num.isEmpty()) {
            numError.visibility = View.VISIBLE
            numError.text = "El número es inválido"
            isValid = false
        } else {
            numError.visibility = View.VISIBLE
            numError.text = ""
        }

        if (email.isEmpty()) {
            emailError.visibility = View.VISIBLE
            emailError.text = "El correo electrónico es inválido"
            isValid = false
        } else {
            emailError.visibility = View.VISIBLE
            emailError.text = ""
        }

        if (isValid) {
            // Aquí podré realizar el registro del usuario
            // llamar a un método en el ViewModel o Presenter
        }

    }
}