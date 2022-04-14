package com.example.recycle_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (private var titles: List<String>, private var details: List<String>, private var images: List<Int>) :
    RecyclerView.Adapter<RecyclerAdapter.Viewholder>() {


    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView = itemView.findViewById(R.id.tv_title)
        val itemDetail: TextView = itemView.findViewById(R.id.tv_description)
        val itemPicture: ImageView = itemView.findViewById(R.id.iv_image)


        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                //Toast.makeText(itemView.context, "You clicked on item # ${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }
    }
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
                val v =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
                return Viewholder(v)
            }

            override fun onBindViewHolder(holder: Viewholder, position: Int) {
                holder.itemTitle.text = titles[position]
                holder.itemDetail.text = details[position]
                holder.itemPicture.setImageResource(images[position])

                holder.itemView.setOnClickListener(object: View.OnClickListener{
                    override fun onClick(p0: View?) {
                        val activity=p0!!.context as AppCompatActivity
                        val demoFragment= Current_weather()
                        activity.supportFragmentManager.beginTransaction().replace(R.id.rec, demoFragment).addToBackStack(null).commit()

                    }
                })

            }

            override fun getItemCount(): Int {
                return titles.size
            }
        }
