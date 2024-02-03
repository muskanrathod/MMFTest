package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapp.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.etMail.setText("test123@example.com")
        binding.etPass.setText("12345678")

        binding.btnLogin.setOnClickListener {
            val email = binding.etMail.text.toString()
            val pass = binding.etPass.text.toString()

            binding.pb.visibility = View.VISIBLE

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(
                    this@LoginActivity,
                    "Please Enter Email & Password",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val apiService = RetrofitClient.retrofit.create(AuthService::class.java)
                val login = LoginRequest(email, pass)

                apiService.login(login).enqueue(object : retrofit2.Callback<Login> {

                    override fun onResponse(call: Call<Login>, response: Response<Login>) {
                        binding.pb.visibility = View.GONE
                        Log.d("TAG", "onResponse: ${response.body()?.record?.authtoken}")
                        Utils.Token = response.body()?.record?.authtoken!!
                        Utils.name = response.body()?.record?.firstName!! + " " + response.body()?.record?.lastName
                        Utils.email = response.body()?.record?.email!!
                        Utils.image = response.body()?.record?.profileImg!!
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    }

                    override fun onFailure(call: Call<Login>, t: Throwable) {
                        binding.pb.visibility = View.GONE
                        Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_LONG).show()
                    }
                })

            }
        }
    }
}