package com.example.androidtest

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.androidtest.ModalClass.Result

import com.squareup.picasso.Picasso
import java.lang.String
import com.example.androidtest.Utils.ImageLoadedCallback

class UserDetail : BaseActivityLogin() {
    var mcontext: Activity? = null
    var txt_name: TextView? = null
    var txt_phone: TextView? = null
    var txt_Gender: TextView? = null
    var txt_email: TextView? = null
    var txt_age: TextView? = null
    var txt_uuid: TextView? = null
    var txt_username: TextView? = null
    var txt_salt: TextView? = null
    var txt_sha1: TextView? = null
    var txt_sha256: TextView? = null
    var img_profile: ImageView? = null
    var progress: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        super.load_menu_bar(this, this, "User Profile Details")
        mcontext = this
        val result = intent.getSerializableExtra("UserData") as Result
        img_profile = findViewById<View>(R.id.profileImage) as ImageView
        txt_name = findViewById<View>(R.id.txt_name) as TextView
        txt_phone = findViewById<View>(R.id.txt_phone) as TextView
        txt_Gender = findViewById<View>(R.id.txt_Gender) as TextView
        txt_email = findViewById<View>(R.id.txt_email) as TextView
        txt_age = findViewById<View>(R.id.txt_age) as TextView
        txt_uuid = findViewById<View>(R.id.txt_uuid) as TextView
        txt_username = findViewById<View>(R.id.txt_username) as TextView
        txt_salt = findViewById<View>(R.id.txt_salt) as TextView
        txt_sha1 = findViewById<View>(R.id.txt_sha1) as TextView
        txt_sha256 = findViewById<View>(R.id.txt_sha256) as TextView
        progress = findViewById<View>(R.id.progress) as ProgressBar
        txt_name!!.text = result!!.name!!.first + " " + result.name!!.last
        txt_phone!!.text = result.phone
        txt_Gender!!.text = result.gender
        txt_email!!.text = result.email
        txt_uuid!!.text = result.login!!.uuid
        txt_username!!.text = result.login!!.username
        txt_salt!!.text = result.login!!.salt
        txt_sha1!!.text = result.login!!.sha1
        txt_sha256!!.text = result.login!!.sha256
        txt_age!!.text = String.valueOf(result.dob!!.age)
        txt_age!!.text = String.valueOf(result.picture!!.thumbnail)
        Picasso.with(mcontext).load(String.valueOf(result.picture!!.thumbnail))
                .resize(120, 120).error(R.drawable.avtar_nav).into(img_profile, object : ImageLoadedCallback(progress!!) {
                    override fun onSuccess() {
                        progress!!.visibility = View.GONE
                    }

                    override fun onError() {
                        progress!!.visibility = View.GONE
                    }
                })
        img_profile!!.invalidate()
    }
}