package com.example.retrofit_zidan_34.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_zidan_34.R
import com.example.retrofit_zidan_34.model.ProvinceResponse
import kotlinx.android.synthetic.main.item_province.view.*

class ProvinceAdapter (private var arrayList: ArrayList<ProvinceResponse>): RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>(){
    inner class ProvinceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(province: ProvinceResponse){
            with(itemView){
                tvName.text = province.attributes.province
                tvPositive.text = province.attributes.positif.toString()
                tvRecover.text = province.attributes.sembuh.toString()
                tvDeath.text = province.attributes.death.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_province,parent,false)
        return ProvinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int = arrayList.size
}