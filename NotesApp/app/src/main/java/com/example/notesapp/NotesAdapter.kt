package com.example.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults
import kotlinx.android.synthetic.main.notes_rv_layout.view.*

class NotesAdapter (val context: Context?, private val notesList: RealmResults<Notes>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.notes_rv_layout, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.titleTV.text = notesList[position]!!.title
        holder.itemView.descTv.text = notesList[position]!!.description
        holder.itemView.idTv.text = notesList[position]!!.id.toString()
    }

}
class ViewHolder(v: View?) : RecyclerView.ViewHolder(v!!), View.OnClickListener {

    override fun onClick(v: View?) {

    }

    init {
        itemView.setOnClickListener(this)
    }
    val title = itemView.findViewById<TextView>(R.id.titleTV)
    val desc = itemView.findViewById<TextView>(R.id.descTv)
    val id = itemView.findViewById<TextView>(R.id.idTv)
}














