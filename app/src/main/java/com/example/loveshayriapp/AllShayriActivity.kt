package com.example.loveshayriapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loveshayriapp.Adopter.AllShayriAdapter
import com.example.loveshayriapp.databinding.ActivityAllShayriBinding
import com.example.loveshayriapp.model.ShayriModel
import com.google.firebase.firestore.FirebaseFirestore

class AllShayriActivity : AppCompatActivity() {
    lateinit var binding:ActivityAllShayriBinding
    lateinit var db:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAllShayriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id")
        val name =intent.getStringExtra("name")
         db= FirebaseFirestore.getInstance()
        binding.btnBack.setOnClickListener{

            onBackPressed()
        }

        binding.catName.text= name.toString()

        db.collection("Shayri").document(id!!).collection("all").addSnapshotListener{value,error ->

            val shayriList= arrayListOf<ShayriModel>()
            val data= value?.toObjects(ShayriModel::class.java)
            shayriList.addAll(data!!)
            binding.rcvAllShayri.layoutManager= LinearLayoutManager(this)
            binding.rcvAllShayri.adapter = AllShayriAdapter(this,shayriList)



        }



    }


}