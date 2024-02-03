package com.example.myapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.GridItemBinding
import com.example.myapp.databinding.ListItemBinding

class GridAdapter(
    var userList: List<UserList>,
) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GridItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(userList[position]){
                binding.tvName.text = this.firstName+" "+this.lastName
                binding.tvMail.text = this.email
                binding.tvPhone.text = this.phoneNo
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}