package com.v2form.hilt.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(val name:String, val age:Int){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}
