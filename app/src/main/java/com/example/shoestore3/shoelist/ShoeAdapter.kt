package com.example.shoestore3.shoelist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore3.databinding.RvListBinding
import com.example.shoestore3.db.ShoeStoreTable
import javax.inject.Inject

class ShoeAdapter @Inject constructor(): RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    var dataList = ArrayList<ShoeStoreTable>()

    inner class ShoeViewHolder(private val binding: RvListBinding) :RecyclerView.ViewHolder(binding.root){
        val textName: TextView = binding.textName
        val textCompany: TextView = binding.textCompany
        val textSize: TextView = binding.textSize
        val textDescription: TextView = binding.textDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val binding = RvListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoeViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder:  ShoeViewHolder, position: Int) {
         //ShoeViewHolder, position: Int)
        val currentItem = shoestoretable[position]
        holder.textName.text = currentItem.name
        holder.textCompany.text = currentItem.company
        holder.textSize.text = currentItem.shoeSize.toString()
        holder.textDescription.text = currentItem.description
    }}

    fun setItems(shoestoretable: List<ShoeStoreTable>) {
        this.shoestoretable.clear()
        this.shoestoretable.addAll(shoestoretable)
        notifyDataSetChanged()
    }


}