package com.example.umkmapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.umkmapps.model.DataItem
import com.example.umkmapps.model.ResponseUser
import com.example.umkmapps.network.ApiConfig
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter
    private lateinit var rvUsers: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        adapter = UserAdapter(mutableListOf())

        rvUsers.setHasFixedSize(true)
        rvUsers.layoutManager = LinearLayoutManager (this)
        rvUsers.adapter = adapter

        getUser()
    }
    private fun getUser(){
        val  client = ApiConfig.getApiservice().getListUsers("1")

        client.enqueue(object : Callback<ResponseUser> {
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>){
                if (response.isSuccessful){
                    val dataArray = response.body()?.data as List<DataItem>
                    for (data in dataArray){
                        adapter.addUser(data)
                    }
                }
            }
            override fun onFailure(call: Call<ResponseUser>, t: Throwable){
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }
}