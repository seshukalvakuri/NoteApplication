package com.example.noteapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NoteAdapter(private val context: Context, private val datasource:ArrayList<Note>):BaseAdapter() {

    private val layoutInflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val listItemRowView:View
        val viewHolder : ViewHolder
        val note = getItem(position)
        if(convertView == null)
        {
            viewHolder = ViewHolder()
            listItemRowView = layoutInflater.inflate(R.layout.note_list_item,parent,false)
            viewHolder.noteTitle = listItemRowView.findViewById<TextView>(R.id.title_tv)
            viewHolder.notedescription = listItemRowView.findViewById<TextView>(R.id.description_tv)
            listItemRowView.tag = viewHolder

        }
        else
        {
            listItemRowView = convertView
            viewHolder = listItemRowView.tag as ViewHolder
        }
        viewHolder.noteTitle.text = note.title
        viewHolder.notedescription.text = note.description

        return listItemRowView
    }

    override fun getItem(position: Int): Note {
        return datasource.get(position)
    }

    override fun getItemId(position: Int): Long {
        return datasource[position].noteID.toLong()
    }

    override fun getCount(): Int {
        return datasource.size
    }

    private class ViewHolder{
        lateinit var noteTitle:TextView
        lateinit var notedescription: TextView
    }


}