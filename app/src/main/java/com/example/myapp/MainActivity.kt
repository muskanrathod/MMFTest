package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapp.databinding.ActivityLoginBinding
import com.example.myapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var userList = ArrayList<UserList>()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.pb.visibility = View.VISIBLE

        binding.tvName.text = Utils.name
        binding.tvMail.text = Utils.email
        Glide.with(this@MainActivity)
            .load(Utils.image)
            .into(binding.ivProfile)

        binding.btnList.setOnClickListener {
            binding.btnList.setBackgroundResource(R.drawable.ic_list_active)
            binding.btnGrid.setBackgroundResource(R.drawable.ic_grid)
            val listAdapter = ListAdapter(userList)
            val layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            binding.rvList.layoutManager = layoutManager
            binding.rvList.adapter = listAdapter
        }

        binding.btnGrid.setOnClickListener {
            binding.btnList.setBackgroundResource(R.drawable.ic_list)
            binding.btnGrid.setBackgroundResource(R.drawable.ic_grid_active)
            val gridAdapter = GridAdapter(userList)
            val layoutManager = GridLayoutManager(this@MainActivity,2, LinearLayoutManager.VERTICAL, false)
            binding.rvList.layoutManager = layoutManager
            binding.rvList.adapter = gridAdapter
        }

        val apiService = MainClient.retrofit.create(MainService::class.java)

        apiService.getUserList().enqueue(object : Callback<ListResponse> {

            override fun onFailure(call: Call<ListResponse>, t: Throwable) {
                Log.d("TAG", "onResponse: ${t.message}")
                binding.pb.visibility = View.GONE
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<ListResponse>,
                response: Response<ListResponse>
            ) {
                binding.pb.visibility = View.GONE
                userList.addAll(response.body()!!.userList)
                binding.btnList.setBackgroundResource(R.drawable.ic_list_active)
                binding.btnGrid.setBackgroundResource(R.drawable.ic_grid)
                val listAdapter = ListAdapter(userList)
                val layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                binding.rvList.layoutManager = layoutManager
                binding.rvList.adapter = listAdapter
            }

        })
    }
}