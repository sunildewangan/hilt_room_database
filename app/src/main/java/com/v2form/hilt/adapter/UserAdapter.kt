package com.v2form.hilt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.v2form.hilt.R
import com.v2form.hilt.model.User

class UserAdapter(private val context:Context, private var userList:ArrayList<User>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name:TextView = itemView.findViewById(R.id.name)
        val age:TextView = itemView.findViewById(R.id.age)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(LayoutInflater.from(context).inflate(R.layout.each_row,parent,false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList[position]

        holder.name.text = user.name
        holder.age.text = user.age.toString()
    }

    override fun getItemCount(): Int  = userList.size


    fun setData(userList: ArrayList<User>){
        this.userList = userList
        notifyDataSetChanged()
    }
}