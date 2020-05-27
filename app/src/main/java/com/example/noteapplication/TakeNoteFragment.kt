package com.example.noteapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText




class TakeNoteFragment : Fragment() {

    interface takeNote {
        fun showNotes(title:String, description:String)
    }

    lateinit var takeNoteObj:takeNote
    lateinit var title_et:EditText
    lateinit var description_et:EditText
    lateinit var add_btn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_take_note, container, false)
        title_et = view.findViewById(R.id.title_et)
        description_et = view.findViewById(R.id.description_et)
        add_btn = view.findViewById(R.id.add_btn)
        add_btn.setOnClickListener {
            takeNoteObj.showNotes(title_et.text.toString(),description_et.text.toString())
        }
return view
    }

}
