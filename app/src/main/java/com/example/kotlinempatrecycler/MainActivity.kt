package com.example.kotlinempatrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.DialogTitle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPahlawan: RecyclerView
    private var list: ArrayList<Pahlawan> = arrayListOf()
    private var title: String = "Pahlawan Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvPahlawan = findViewById(R.id.rv_pahlawan)
        rvPahlawan.setHasFixedSize(true)

        list.addAll(DataPahlawan.HeroesData.listData)
        showRecylerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when(selectedMode){
            R.id.action_list -> {
                title = "Pahlawan Mode List"
                showRecylerList()
            }
            R.id.action_grid -> {
                title = "Pahlawan Mode Grid"
                showRecyclerGrid()
            }
            R.id.action_card -> {
                title = "Pahlawan Mode Card View"
                showRecyclerCard()
            }
        }
        setActionBarTitle(title)
    }

    private fun showRecylerList() {
        //TODO("Not yet implemented")
        rvPahlawan.layoutManager = LinearLayoutManager(this)
        val listPahlawanAdapter = ListPahlawanAdapter(list)
        rvPahlawan.adapter = listPahlawanAdapter
    }

    private fun showRecyclerGrid(){
        rvPahlawan.layoutManager = GridLayoutManager(this, 2)
        val gridPahlawanAdapter = GridPahlawanAdapter(list)
        rvPahlawan.adapter = gridPahlawanAdapter
    }

    private fun showRecyclerCard(){
        rvPahlawan.layoutManager = LinearLayoutManager(this)
        val cardPahlawanAdapter = CardPahlawanAdapter(list)
        rvPahlawan.adapter = cardPahlawanAdapter
    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }
}