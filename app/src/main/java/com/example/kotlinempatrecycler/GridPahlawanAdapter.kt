package com.example.kotlinempatrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class GridPahlawanAdapter(private val listHero:ArrayList<Pahlawan>) : RecyclerView.Adapter<GridPahlawanAdapter.GridViewHolder>() {
    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgFoto: ImageView = itemView.findViewById(R.id.img_grid_foto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        //TODO("Not yet implemented")
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.grid_pahlawan, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        //TODO("Not yet implemented")
        val pahlawan = listHero[position]

        Glide.with(holder.itemView.context)
            .load(pahlawan.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgFoto)
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return  listHero.size
    }
}