package co.cyclopsapps.mvvmpokedex.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import co.cyclopsapps.mvvmpokedex.R
import co.cyclopsapps.mvvmpokedex.databinding.FragmentPokemonDetailBinding
import co.cyclopsapps.mvvmpokedex.viewmodels.PokeInfoViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_pokemon_detail.*

class PokemonDetailFragment : Fragment() {

    lateinit var binding: FragmentPokemonDetailBinding
    lateinit var viewModel: PokeInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this).get(PokeInfoViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pokemon_detail, container, false)
        binding.pokeDetailViewModel = viewModel

        initUI()

        return binding.root
    }

    private fun initUI() {
        //val id = intent.extras?.get("id") as Int

        viewModel.getPokemonInfo(id)

        viewModel.pokemonInfo.observe(viewLifecycleOwner, Observer { pokemon ->
            nameTextView.text = pokemon.name
            heightText.text = "Altura: ${pokemon.height/10.0}m"
            weightText.text = "Peso: ${pokemon.weight/10.0}"

            Glide.with(this).load(pokemon.sprites.frontDefault).into(imageView)
        })
    }

}