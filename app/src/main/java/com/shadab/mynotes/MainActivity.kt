 package com.shadab.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item = ArrayList<MainNotes>()
        item.add(
            MainNotes(
                R.drawable.notes,"OS","https://firebasestorage.googleapis.com/v0/b/mynotes-94567.appspot.com/o/Operating%20System%20Syllabus.pdf?alt=media&token=e5c365de-baa0-4bee-8475-ac5c0df5e724"
            )
        )

    }

     override fun onCreateOptionsMenu(menu: Menu): Boolean {
         val inflater = menuInflater.inflate(R.menu.my_menu,menu)
         return true
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         when(item?.itemId){
             R.id.privatenotes->{
                 var intent= Intent(this@MainActivity,MoreDetails::class.java)
                 startActivity(intent)
             }
             R.id.exit->{
                 finish()
             }
         }
         return super.onOptionsItemSelected(item)
     }

 }