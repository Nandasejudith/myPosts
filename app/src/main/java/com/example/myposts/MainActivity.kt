package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getPosts(){
        var retrofit = ApiClient.buidApiClient(ApiInterface::class.java)
        var request = retrofit.getPosts()

        request.enqueue(object  : Callback<List<PostItem>?>) {
            override fun onResponse(call: call<List<PostItem>?>, response: Response<List<PostItem>?> {
                var postList  = response
        }
        }

        overide fun onFailure(call: Call<List<Post>>, t: Throwable) {

        }
    })
}
