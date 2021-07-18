package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.service.quicksettings.Tile
import android.widget.TextView
import android.widget.Toast
import javax.security.auth.callback.Callback


class commentsActivity : AppCompatActivity() {
    var postId = 0
    lateinit var tvPostTittle: TextView
    lateinit var tvPostBody: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        postId = intent.getIntExtra(name:"postId",defaultValue:0)
        castViews()
        getPost()
    }

    fun castViews(){
        tvPostTittle= findViewById(R.id.tvTittle)
        tvPostBody = findViewById(R.id.tvPostBody)
    }

    fun getPost(){
        if (postId==0){
            Toast.makeText(baseContext, text"Post not found",Toast.LENGTH_LONG).show()
            finish()
        }

        var apiClient =ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPost(postId)

        request.enqueue(object : Callback<PostItem>, response: Reaponse<PostItem>) {
            if (response.isSuccessful)
                var post = response.body()
                tvPostBody.text = post?.my body
                        tvPostTittle.text = post?.tittle


        }
    }

    override fun onFailure(call: Call<PostItem>,t: Throwable) {

    }
}