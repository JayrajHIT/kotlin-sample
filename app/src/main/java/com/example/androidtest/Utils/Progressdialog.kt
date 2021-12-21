package com.example.androidtest.Utils

import android.app.Activity
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.TextView
import com.example.androidtest.R

class Progressdialog : Activity() {
    var context: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.utility)
        context = this
    }

    fun loader(cont: Context, msg: String?) {
        /*
		 * mProgressDialog = new ProgressDialog(cont);
		 * mProgressDialog.setMessage("Loading...");
		 * mProgressDialog.setCanceledOnTouchOutside(false);
		 * mProgressDialog.setCancelable(false);
		 * mProgressDialog.getWindow().setGravity(Gravity.CENTER);
		 * mProgressDialog
		 * .getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		 * mProgressDialog.show();
		 */
        // mProgressDialog.setContentView(R.layout.utility);
        if (dialog != null) {
            dialog!!.dismiss()
        }
        dialog = Dialog(cont)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        // tell the Dialog to use the dialog.xml as it's layout description.
        dialog!!.setCancelable(false)
        dialog!!.setContentView(R.layout.progress_dialog)
        val txt_msg = dialog!!.findViewById<View>(R.id.txt_msg) as TextView
        txt_msg.text = msg
        txt_msg.visibility = View.GONE
        dialog!!.window!!.setBackgroundDrawable(
                ColorDrawable(cont.resources.getColor(android.R.color.transparent)))
        dialog!!.show()
    }

    fun unloader(cont: Context?) {
        /*
		 * if(mProgressDialog!=null && mProgressDialog.isShowing()){
		 * mProgressDialog.dismiss(); }
		 */
        Log.e("unloader", "unloader")
        if (dialog != null && dialog!!.isShowing) {
            dialog!!.dismiss()
        }
    }

    companion object {
        var mProgressDialog: ProgressDialog? = null
        var dialog: Dialog? = null
    }
}