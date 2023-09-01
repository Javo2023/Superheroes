package com.example.superheroes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.superheroes.R
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

    class ItemSuperheroViewHolder (val bindingHero:ItemSuperheroBinding):RecyclerView.ViewHolder(bindingHero.root){
        fun bind(superhero:SuperheroEntity){
            bindingHero.image.load(superhero.imagen)
            bindingHero.tvName.text = superhero.nombre
            bindingHero.tvid.text = superhero.id.toString()
            bindingHero.tvOrigin.text = superhero.origen
            bindingHero.tvcreacion.text = superhero.aniocreacion.toString()
            bindingHero.tvPower.text = superhero.poder
            bindingHero.cardItem.setOnClickListener {


                val bundle = Bundle()
                bundle.putString("id", superhero.id.toString())

                Navigation.findNavController(bindingHero.root)
                    .navigate(R.id.action_listFragment_to_detailFragment, bundle)

            }

        }

    }

}