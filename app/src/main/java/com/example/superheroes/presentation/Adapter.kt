package com.example.superheroes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.superheroes.data.local.SuperheroEntity
import com.example.superheroes.databinding.ItemSuperheroBinding

class Adapter : RecyclerView.Adapter<Adapter.ItemSuperheroViewHolder>(){
    lateinit var binding: ItemSuperheroBinding
    private val listItemSuperhero = mutableListOf<SuperheroEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSuperheroViewHolder {
        binding = ItemSuperheroBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemSuperheroViewHolder(binding)


    }

    override fun getItemCount(): Int {
        return listItemSuperhero.size
    }

    override fun onBindViewHolder(holder: ItemSuperheroViewHolder, position: Int) {
        val superheroe = listItemSuperhero[position]
        holder.bind(superheroe)
    }
    fun setData(superheroes:List<SuperheroEntity>){
        this.listItemSuperhero.clear()
        this.listItemSuperhero.addAll(superheroes)
        notifyDataSetChanged()

    }

    class ItemSuperheroViewHolder (val bindinghero:ItemSuperheroBinding):RecyclerView.ViewHolder(bindinghero.root){
        fun bind(superhero:SuperheroEntity){
            bindinghero.image.load(superhero.imagen)
            bindinghero.tvName.text = superhero.nombre

            val bundle = Bundle()
            bundle.putString("id", superhero.id.toString())

        }

    }

}