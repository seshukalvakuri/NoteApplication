package com.example.noteapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast


class ShowNoteFragment : Fragment() {
    val notes:ArrayList<Note> = ArrayList()
    private lateinit var noteListView: ListView
    lateinit var noteCustomAdapter:NoteAdapter


    public fun showNotes(title:String, description:String){
        val note = Note(1, title,description)
        notes.add(note)
        noteCustomAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_show_note, container, false)
        noteListView = view.findViewById<ListView>(R.id.note_lv)
        noteCustomAdapter = NoteAdapter(activity!!.baseContext,notes)
        noteListView.adapter = noteCustomAdapter

        noteListView.setOnItemClickListener {
                parent,View,position,id ->
            val note = notes.get(position)
            Toast.makeText(this.activity,"list of notes", Toast.LENGTH_LONG).show()
        }
        return view
    }




}
