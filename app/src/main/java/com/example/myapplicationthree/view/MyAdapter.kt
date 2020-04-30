package com.example.myapplicationthree.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationthree.R
import com.example.myapplicationthree.model.Senator
import kotlinx.android.synthetic.main.list_item.view.*

class MyAdapter (context: Context): RecyclerView.Adapter<MyAdapter.MyCustomViewHolder>() {

    var senators: List<Senator> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    inner class MyCustomViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val senatorName = view.tv_senator_name
        private val senatorDescription = view.tv_senator_description

        fun bind(senator: Senator) {
            val name = "${senator.person.firstname} ${senator.person.lastname}"
            senatorName.text = name
            senatorDescription.text = senator.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomViewHolder {
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return MyCustomViewHolder(view)
    }

    override fun getItemCount() = senators.size

    override fun onBindViewHolder(holder: MyCustomViewHolder, position: Int) {
        holder.bind(senators[position])
    }
}