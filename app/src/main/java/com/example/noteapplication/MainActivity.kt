package com.example.noteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , TakeNoteFragment.takeNote{


    lateinit var showNoteFragment : ShowNoteFragment




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showNoteFragment = fragmentid as ShowNoteFragment
            loadFragment()

    }
    private fun loadFragment(){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val takeNoteFragment = TakeNoteFragment()
        takeNoteFragment.takeNoteObj= this
        fragmentTransaction.add(R.id.framelayoutid,takeNoteFragment)
        fragmentTransaction.commit()
    }



    override fun showNotes(title: String, description: String) {
        showNoteFragment.showNotes(title,description)

    }


}
