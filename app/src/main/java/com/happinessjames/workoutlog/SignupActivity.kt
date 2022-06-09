package com.happinessjames.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var btnSignup:Button
    lateinit var tilFirstname:TextInputLayout
    lateinit var etFirstname: TextInputEditText
    lateinit var tilLastname:TextInputLayout
    lateinit var etLastname:TextInputEditText
    lateinit var tilEmailsignup:TextInputLayout
    lateinit var etEmailsignup:TextInputEditText
    lateinit var tilPasswordsignup: TextInputLayout
    lateinit var etPasswordsignup: TextInputEditText
    lateinit var tilConfirmation:TextInputLayout
    lateinit var etConfirmation:TextInputEditText
    lateinit var tvLogin:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        clickViewSignup()

        btnSignup.setOnClickListener {
            validationSignup()
        }
        tvLogin.setOnClickListener { val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent) }
    }
    fun clickViewSignup(){
        btnSignup = findViewById(R.id.btnSignup)
        tilFirstname = findViewById(R.id.tilFirstname)
        etFirstname = findViewById(R.id.etFirstname)
        tilLastname = findViewById(R.id.tilLastname)
        etLastname = findViewById(R.id.etLastname)
        tilEmailsignup = findViewById(R.id.tilEmailsignup)
        etEmailsignup = findViewById(R.id.etEmailsignup)
        tilPasswordsignup = findViewById(R.id.tilPasswordsignup)
        etPasswordsignup = findViewById(R.id.etPasswordsignup)
        tilConfirmation = findViewById(R.id.tilConfirmation)
        etConfirmation = findViewById(R.id.etConfirmation)
        tvLogin = findViewById(R.id.tvLogin)

    }
    fun validationSignup(){
        var error = false
        tilFirstname.error = null
        tilLastname.error = null
        tilEmailsignup.error = null
        tilPasswordsignup.error = null
        tilConfirmation.error = null
        var firstname = etFirstname.text.toString()
        if (firstname.isBlank()){
            tilFirstname.error = " First name is required"
            error = true
        }
        var lastname = etLastname.text.toString()
        if (lastname.isBlank()){
            tilLastname.error = " Last name is required"
            error = true
        }
        var emailsignup = etEmailsignup.text.toString()
        if (emailsignup.isBlank()){
            tilEmailsignup.error = " Email is required"
            error = true
        }
        var passwordsignup = etPasswordsignup.text.toString()
        if (passwordsignup.isBlank()){
            tilPasswordsignup.error = " Password is required"
            error = true
        }
        var confirmation = etConfirmation.text.toString()
        if (confirmation.isBlank()){
            tilConfirmation.error = " Confirm Password is required"
            error = true
        }
        if (passwordsignup!=confirmation){
            tilConfirmation.error = "Password does not match"
        }
    }
}