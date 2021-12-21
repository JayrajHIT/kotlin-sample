package com.example.androidtest

import android.app.Activity
import android.app.ProgressDialog
import android.os.Bundle
import android.view.View

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtest.Adapter.DataShowAdapter
import com.example.androidtest.ModalClass.Result
import com.example.androidtest.ModalClass.UserData
import com.example.sammple.ApiCall.RetrofitClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : BaseActivityLogin() {
    var mcontext: Activity? = null
    var recycle__list: RecyclerView? = null
    var mLayoutManager: LinearLayoutManager? = null
    var dataShowAdapter: DataShowAdapter? = null
    var list: ArrayList<Result>? = null
    var progress:ProgressDialog? = null
    var stringArrayList: ArrayList<String>? = null
    var model: UserData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        super.load_menu_bar(this, this, "User Data")
        mcontext = this
        recycle__list = findViewById<View>(R.id.recycle_view_list) as RecyclerView
        mLayoutManager = LinearLayoutManager(mcontext)
        recycle__list!!.layoutManager = mLayoutManager
        recycle__list!!.addItemDecoration(
            DividerItemDecoration(
                mcontext,
                LinearLayoutManager.VERTICAL
            )
        )
        recycle__list!!.adapter = dataShowAdapter
        //Call Api
        progress = ProgressDialog(this)
        progress!!.setTitle("Loading")
        progress!!.setMessage("Wait while loading...");
        progress!!.setCancelable(false) // disable dismiss by tapping outside of the dialog

        progress!!.show()
        Getdata()
    }

    private fun Getdata() {
        // Call Api by Retrofit Client
        val call: Call<UserData?>? = RetrofitClient.instance?.myApi?.GetUserData()
        call?.enqueue(object : Callback<UserData?> {
            override fun onResponse(call: Call<UserData?>, response: Response<UserData?>) {
// To dismiss the dialog
                progress!!.dismiss()
                val datatable = response.body()
                list = datatable!!.results as ArrayList<com.example.androidtest.ModalClass.Result>?
                dataShowAdapter = DataShowAdapter(list!!, mcontext!!)
                recycle__list!!.adapter = dataShowAdapter
            }

            override fun onFailure(call: Call<UserData?>, t: Throwable) {

            }
        })
    }
}