package com.example.kotlinempatrecycler

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListPahlawanAdapter(private val listHero: ArrayList<Pahlawan>) : RecyclerView.Adapter<ListPahlawanAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNama: TextView = itemView.findViewById(R.id.tv_nama_pahlawan)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_detail_pahlawan)
        var imgFoto: ImageView = itemView.findViewById(R.id.foto_pahlawan)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        //TODO("Not yet implemented")
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.daftar_pahlawan, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        //TODO("Not yet implemented")
        val pahlawan = listHero[position]

        Glide.with(holder.itemView.context)
            .load(pahlawan.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgFoto)

        holder.tvNama.text = pahlawan.name
        holder.tvDetail.text = pahlawan.detail
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return  listHero.size
    }

}