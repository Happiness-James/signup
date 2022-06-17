package com.happinessjames.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.happinessjames.workoutlog.databinding.ActivityHomeBinding
import com.happinessjames.workoutlog.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
   lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            validationSignup()
        }
        binding.tvLogin.setOnClickListener { val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent) }
    }
    fun validationSignup(){
        var error = false
        binding.tilFirstname.error = null
        binding.tilLastname.error = null
        binding.tilEmailsignup.error = null
        binding.tilPasswordsignup.error = null
        binding.tilConfirmation.error = null
        var firstname = binding.etFirstname.text.toString()
        if (firstname.isBlank()){
            binding.tilFirstname.error = " First name is required"
            error = true
        }
        var lastname = binding.etLastname.text.toString()
        if (lastname.isBlank()){
            binding.tilLastname.error = " Last name is required"
            error = true
        }
        var emailsignup = binding.etEmailsignup.text.toString()
        if (emailsignup.isBlank()){
            binding.tilEmailsignup.error = " Email is required"
            error = true
        }
        var passwordsignup = binding.etPasswordsignup.text.toString()
        if (passwordsignup.isBlank()){
            binding.tilPasswordsignup.error = " Password is required"
            error = true
        }
        var confirmation = binding.etConfirmation.text.toString()
        if (confirmation.isBlank()){
            binding.tilConfirmation.error = " Confirm Password is required"
            error = true
        }
        if (passwordsignup!=confirmation){
            binding.tilConfirmation.error = "Password does not match"
        }
    }
}