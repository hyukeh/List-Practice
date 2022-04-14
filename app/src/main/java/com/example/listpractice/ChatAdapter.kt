package com.example.listpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.persistableBundleOf
import com.example.listpractice.util.ChatRoomInfo
import java.util.*

class ChatAdapter:RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    private var data:MutableList<ChatRoomInfo> = mutableListOf()

    fun setData(data:MutableList<ChatRoomInfo>){
        this.data = data
        notifyDataSetChanged()
    }

    fun swapItem(from:Int, to:Int){
        Collections.swap(data, from, to)
        notifyItemMoved(from, to)
    }

    fun removeItem(index:Int){
        data.removeAt(index)
        notifyItemRemoved(index)
    }


    class ChatViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textViewName: TextView = v.findViewById(R.id.textViewName)
        val textViewTime: TextView = v.findViewById(R.id.textViewTime)
        val imageView: ImageView = v.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat_list, parent, false)
        return ChatViewHolder(v)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = data[position]
        holder.imageView.setImageResource(item.image)
        holder.textViewName.text = item.name
        holder.textViewTime.text = item.time
    }

    override fun getItemCount(): Int {
        return data.size
    }
}