package com.mafiaz.authenapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mafiaz.authenapi.databinding.ActivityMainBinding
import com.mafiaz.authenapi.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.token.observe(this){ response ->
            if(response == null){
                Toast.makeText(this,"Cannot login at the moment",Toast.LENGTH_SHORT).show()
                return@observe
            }

            Log.e("Token",""+response.token)
        }

        _binding.btnLogin.setOnClickListener { login() }
    }

    private fun login(){
        val email = _binding.edtUsername.text.toString()
        val password = _binding.edtPassword.text.toString()

        viewModel.loginRequest(email, password)
    }
}