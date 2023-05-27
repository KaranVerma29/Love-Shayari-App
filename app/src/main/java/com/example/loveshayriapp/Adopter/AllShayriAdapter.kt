package com.example.loveshayriapp.Adopter

import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.loveshayriapp.AllShayriActivity
import com.example.loveshayriapp.BuildConfig
import com.example.loveshayriapp.databinding.ItemShayriBinding
import com.example.loveshayriapp.model.ShayriModel


class AllShayriAdapter(val allShayriActivity: AllShayriActivity, val shayriList: ArrayList<ShayriModel>) : RecyclerView.Adapter<AllShayriAdapter.ShayiViewHolder>(){

    val colorsList= arrayListOf<String>("#c56cf0","#ff9f1a","#18dcff","#7efff5","#fff200","#c56cf0","#32ff7e")

    class ShayiViewHolder(val binding:ItemShayriBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShayiViewHolder {
        return ShayiViewHolder(ItemShayriBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false))
    }

    override fun onBindViewHolder(holder: ShayiViewHolder, position: Int) {
        if (position % 7 == 0) {
            holder.binding.itemShayri.setBackgroundColor(Color.parseColor(colorsList[0]))
        } else if (position % 7 == 1) {
            holder.binding.itemShayri.setBackgroundColor(Color.parseColor(colorsList[1]))
        } else if (position % 7 == 2) {
            holder.binding.itemShayri.setBackgroundColor(Color.parseColor(colorsList[2]))
        } else if (position % 7 == 3) {
            holder.binding.itemShayri.setBackgroundColor(Color.parseColor(colorsList[3]))
        } else if (position % 7 == 4) {
            holder.binding.itemShayri.setBackgroundColor(Color.parseColor(colorsList[4]))
        } else if (position % 7 == 5) {
            holder.binding.itemShayri.setBackgroundColor(Color.parseColor(colorsList[5]))
        } else if (position % 7 == 6) {
            holder.binding.itemShayri.setBackgroundColor(Color.parseColor(colorsList[6]))
        }





        holder.binding.itemShayri.text = shayriList[position].data.toString()
        holder.binding.btnShare.setOnClickListener{
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                var shareMessage = "\n${shayriList[position].data}\n\n"
                shareMessage =
                    """
                            ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                            
                            
                            """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                allShayriActivity.startActivity(Intent.createChooser(shareIntent,shayriList[position].data.toString()))
            } catch (e: Exception) {
                //e.toString();
            }
            Toast.makeText(allShayriActivity, "Shayri share successfully", Toast.LENGTH_SHORT).show()
        }


      holder.binding.btnCopy.setOnClickListener{

          val clipboard =allShayriActivity.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
          val clip = ClipData.newPlainText("label", shayriList[position].data.toString())
          clipboard!!.setPrimaryClip(clip)
          Toast.makeText(allShayriActivity, "Shayri copied successfully", Toast.LENGTH_SHORT).show()
      }

      holder.binding.btnWhatsapp.setOnClickListener{
          val whatsappIntent = Intent(Intent.ACTION_SEND)
          whatsappIntent.type = "text/plain"
          whatsappIntent.setPackage("com.whatsapp")
          whatsappIntent.putExtra(Intent.EXTRA_TEXT,shayriList[position].data.toString())
          try {
              allShayriActivity.startActivity(whatsappIntent)
          } catch (ex: ActivityNotFoundException) {

          }

      }

    }
    override fun getItemCount() = shayriList.size


}