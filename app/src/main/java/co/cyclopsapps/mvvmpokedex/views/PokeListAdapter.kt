package co.cyclopsapps.mvvmpokedex.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import co.cyclopsapps.mvvmpokedex.R
import co.cyclopsapps.mvvmpokedex.databinding.CardPokemonSearchBinding
import co.cyclopsapps.mvvmpokedex.models.PokeResult
import kotlinx.android.synthetic.main.card_pokemon_search.view.*

class PokeListAdapter(val pokemonClick: (Int) -> Unit): RecyclerView.Adapter<PokeListAdapter.SearchViewHolder>() {
    var pokemonList: List<PokeResult> = emptyList<PokeResult>()
    val resource = R.layout.card_pokemon_search
    lateinit var context: Context

    fun setData(list: List<PokeResult>){
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        context = parent.context
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: CardPokemonSearchBinding = DataBindingUtil.inflate(layoutInflater, resource, parent, false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.pokemonText.text = "#${position + 1} - ${pokemon.name}"

        holder.itemView.setOnClickListener { pokemonClick(position + 1) }
    }

    inner class SearchViewHolder(binding: CardPokemonSearchBinding): RecyclerView.ViewHolder(binding.root) {
        var binding: CardPokemonSearchBinding? = null

        init {
            this.binding = binding
        }

    }
   /* var pokemonList: List<PokeResult> = emptyList<PokeResult>()

    fun setData(list: List<PokeResult>){
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_pokemon_search, parent,false))
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.pokemonText.text = "#${position + 1} - ${pokemon.name}"

        holder.itemView.setOnClickListener { pokemonClick(position + 1) }
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)*/
}