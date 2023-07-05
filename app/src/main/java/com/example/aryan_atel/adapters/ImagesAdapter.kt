package com.example.aryan_atel.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.aryan_atel.R
import com.example.aryan_atel.models.Jokes
import com.example.aryan_atel.viewModel.ImagesViewModel

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.MyViewHolder>() {



    private var imagesList: List<Jokes>?=null

    fun setImageList(imagesList: List<Jokes>?){
        this.imagesList=imagesList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesAdapter.MyViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.images_layout,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImagesAdapter.MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        if (imagesList==null){
            return 0
        }
        else{
            return imagesList?.size!!
        }
    }


    class MyViewHolder(view :View ): RecyclerView.ViewHolder(view), LifecycleOwner {

       val images= view.findViewById<ImageView>(R.id.Images)


        fun bind(info :ImagesViewModel){

            info.image.observe(this) {

                it.data.memes.iterator().forEach { pics ->

                    Log.d("original", "---------> " + pics.url)


                }

            }

        }

        override val lifecycle: Lifecycle
            get() = TODO("Not yet implemented")


    }

}