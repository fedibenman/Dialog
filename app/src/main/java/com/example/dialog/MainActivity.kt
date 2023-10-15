package com.example.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dialog.ui.theme.DialogTheme

class MainActivity : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override  fun onCreate (savedInstanceState : Bundle?){

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialogA = AlertDialog.Builder(this)
        val dialog = dialogA.create()
        val dialogview = layoutInflater.inflate(R.layout.progressdialog , null)
        val txtview = dialogview.findViewById<TextView>(R.id.message)
        txtview.text = getString(R.string.messagetext)
        dialog.setView(dialogview)
        dialog.show()
        Handler(Looper.getMainLooper()).postDelayed({dialog.dismiss()},5000)
    }

    override fun onBackPressed(){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("do you want to close the application")
        builder.setPositiveButton("No",{dialogin:DialogInterface , i:Int->})
        builder.setNegativeButton("Yes",{dialogin:DialogInterface , i:Int->finish()})
        builder.show()

    }



}