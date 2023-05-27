package com.example.loveshayriapp.Adopter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loveshayriapp.AllShayriActivity
import com.example.loveshayriapp.MainActivity
import com.example.loveshayriapp.databinding.ItemCategoryBinding
import com.example.loveshayriapp.model.CategoryModel

class CategoryAdopter(val mainActivity: MainActivity, val list: ArrayList<CategoryModel>) :RecyclerView.Adapter<CategoryAdopter.CatViewHolder>(){

    val colorsList= arrayListOf<String>("#fffa65","#ff4d4d","#ffcccc","#32ff7e","#7d5fff",
                                        "#cd84f1","#18dcff","#ffaf40","#B53471","#009432")

    class CatViewHolder (val binding:ItemCategoryBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false))
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {

        if (position%10==0)
        {
          holder.binding.itemTxt.setBackgroundColor(Color.parseColor(colorsList[0]))
        }else if (position%10==1)
        {
            holder.binding.itemTxt.setBackgroundColor(Color.parseColor(colorsList[1]))
        }else if (position%10==2)
        {
            holder.binding.itemTxt.setBackgroundColor(Color.parseColor(colorsList[2]))
        }else if (position%10==3)
        {
            holder.binding.itemTxt.setBackgroundColor(Color.parseColor(colorsList[3]))
        }else if (position%10==4)
        {
            holder.binding.itemTxt.setBackgroundColor(Color.parseColor(colorsList[4]))
        }else if (position%10==5)
        {
            holder.binding.itemTxt.setBackgroundColor(Color.parseColor(colorsList[5]))
        }else if (position%10==6)
        {
            holder.binding.itemTxt.setBackgroundColor(Color.parseColor(colorsList[6]))
        }else if (position%10==7)
        {
            holder.binding.itemTxt.setBackgroundColor(Color.parseColor(colorsList[7]))
        }else if (position%10==8)
        {
            holder.binding.itemTxt.setBackgroundColor(Color.parseColor(colorsList[8]))
        }else if (position%10==9)
        {
            holder.binding.itemTxt.setBackgroundColor(Color.parseColor(colorsList[9]))
        }




        holder.binding.itemTxt.text = list[position].name.toString()
        holder.binding.root.setOnClickListener{

            val intent= Intent(mainActivity,AllShayriActivity::class.java)
            intent.putExtra("id",list[position].id)
            intent.putExtra("name",list[position].name)
            mainActivity.startActivity(intent)
        }

    }

    override fun getItemCount()= list.size



}