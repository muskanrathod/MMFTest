package com.example.myapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.ListItemBinding

class ListAdapter(
    var userList: List<UserList>,
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

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