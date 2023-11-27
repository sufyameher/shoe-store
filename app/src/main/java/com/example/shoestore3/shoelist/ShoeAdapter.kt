package com.example.shoestore3.shoelist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore3.databinding.RvItemBinding
import com.example.shoestore3.databinding.RvListBinding
import com.example.shoestore3.db.ShoeStoreEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShoeAdapter @Inject constructor() : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    var dataList = ArrayList<ShoeStoreEntity>()

    inner class ShoeViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val textName: TextView = binding.textName
        val textCompany: TextView = binding.textCompany
        val textSize: TextView = binding.textSize
        val textDescription: TextView = binding.textDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        //ShoeViewHolder, position: Int)
        val currentItem = dataList[position]
        holder.textName.text = currentItem.name
        holder.textCompany.text = currentItem.company
        holder.textSize.text = currentItem.size.toString()
        holder.textDescription.text = currentItem.description
    }

    fun setItems(shoestoretable: List<ShoeStoreEntity>) {
        dataList.clear()
        dataList.addAll((shoestoretable))
        notifyDataSetChanged()
    }
}