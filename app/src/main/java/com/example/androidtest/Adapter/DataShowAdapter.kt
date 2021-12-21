package com.example.androidtest.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtest.Adapter.DataShowAdapter.MyViewHolder
import com.example.androidtest.ModalClass.Result
import com.example.androidtest.R
import com.example.androidtest.UserDetail
import com.example.androidtest.Utils.ImageLoadedCallback
import com.squareup.picasso.Picasso
import java.util.*

class DataShowAdapter(var mEntries: ArrayList<Result>, var context: Context) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_data_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txt_name.text = (mEntries[position].name?.first as CharSequence).toString() + " " +
                mEntries[position].name?.last as CharSequence
        holder.txt_phoneno.text = mEntries[position].phone as CharSequence
        holder.txt_Gender.text = mEntries[position].gender as CharSequence
        Picasso.with(context).load(  mEntries[position].picture?.thumbnail )
                .resize(60, 60).error(R.drawable.avtar_nav).into(holder.img_profile, object : ImageLoadedCallback(holder.progress) {
                    override fun onSuccess() {
                        holder.progress.visibility = View.GONE
                    }

                    override fun onError() {
                        holder.progress.visibility = View.GONE
                    }
                })
        holder.img_profile.invalidate()
        holder.mainview.setOnClickListener {
            val intent = Intent(context, UserDetail:: class.java)
            intent.putExtra("UserData", mEntries[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mEntries.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txt_name: TextView
        var txt_phoneno: TextView
        var txt_Gender: TextView
        var img_profile: ImageView
        var mainview: LinearLayout
        var progress: ProgressBar

        init {
            progress = view.findViewById<View>(R.id.progress) as ProgressBar
            mainview = view.findViewById<View>(R.id.mainview) as LinearLayout
            img_profile = view.findViewById<View>(R.id.profileImage) as ImageView
            txt_name = view.findViewById<View>(R.id.txt_name) as TextView
            txt_phoneno = view.findViewById<View>(R.id.txt_phoneno) as TextView
            txt_Gender = view.findViewById<View>(R.id.txt_Gender) as TextView
        }
    }
}


