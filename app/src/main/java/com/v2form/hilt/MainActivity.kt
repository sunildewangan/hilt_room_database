package com.v2form.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.v2form.hilt.adapter.UserAdapter
import com.v2form.hilt.databinding.ActivityMainBinding
import com.v2form.hilt.model.User
import com.v2form.hilt.module.Main
import com.v2form.hilt.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        initRecyclerView()
        userViewModel.getUserData.observe(this, Observer { response ->
            userAdapter.setData(response as ArrayList<User>)
        })

        activityMainBinding.save.setOnClickListener {
            insertIntoRoom()
        }
    }

    private fun initRecyclerView(){
        userAdapter = UserAdapter(this, ArrayList())

        activityMainBinding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }

    private fun insertIntoRoom(){
        val mName = activityMainBinding.name.text.toString()
        val mAge = activityMainBinding.age.text.toString()

        if(!TextUtils.isEmpty(mName) && !TextUtils.isEmpty(mAge)){
            val user = User(mName,mAge.toInt())
            userViewModel.insert(user)
            Toast.makeText(this,"Data Inserted Successfully ", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Please fill all the field", Toast.LENGTH_SHORT).show()
        }
    }
}