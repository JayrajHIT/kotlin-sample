package com.example.androidtest

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * Created by Narendra on 4/8/2016.
 */
open class BaseActivityLogin : AppCompatActivity() {
    var cntxt: Context? = null
    var host_activity: Activity? = null
    var toolbar: Toolbar? = null
    protected fun load_menu_bar(paramContext: Context?, paramActivity: Activity?, title: String?) {
        cntxt = paramContext
        host_activity = paramActivity
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        if (toolbar != null) {
            toolbar!!.setNavigationIcon(R.drawable.ic_action_back)
            toolbar!!
                    .setNavigationOnClickListener { onBackPressed() }
        }
        if (toolbar != null) // toolbar.getBackground().setAlpha(0);
            supportActionBar!!.title = title
    }

    override fun onBackPressed() {
        finish()
    }
}