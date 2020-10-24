package com.example.kotlinempatrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.card_pahlawan.view.*

class CardPahlawanAdapter(private val listHero: ArrayList<Pahlawan>) : RecyclerView.Adapter<CardPahlawanAdapter.CardPahlawanHolder>() {
    class CardPahlawanHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName : TextView = itemView.findViewById(R.id.tv_card_nama)
        var tvDetails : TextView = itemView.findViewById(R.id.tv_card_detail)
        var imgFoto : ImageView = itemView.findViewById(R.id.img_card_foto)
        var btnFav : Button = itemView.findViewById(R.id.btn_fav)
        var btnShare : Button = itemView.findViewById(R.id.btn_share)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardPahlawanHolder {
        //TODO("Not yet implemented")
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_pahlawan, parent, false)
        return CardPahlawanHolder(view)
    }

    override fun onBindViewHolder(holder: CardPahlawanHolder, position: Int) {
        //TODO("Not yet implemented")
        val pahlawan = listHero[position]

        Glide.with(holder.itemView.context)
            .load(pahlawan.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgFoto)

        holder.tvName.text = pahlawan.name
        holder.tvDetails.text = pahlawan.detail

        holder.btnFav.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Favorite " + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }

        holder.btnShare.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Share " + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listHero[holder.adapterPosition].name + " Sebagai Pahlawan!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return listHero.size
    }
}