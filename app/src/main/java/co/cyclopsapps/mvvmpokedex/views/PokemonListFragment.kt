package co.cyclopsapps.mvvmpokedex.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import co.cyclopsapps.mvvmpokedex.R
import co.cyclopsapps.mvvmpokedex.databinding.FragmentPokemonListBinding
import co.cyclopsapps.mvvmpokedex.viewmodels.PokeListViewModel
import kotlinx.android.synthetic.main.fragment_pokemon_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PokemonListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokemonListFragment : Fragment() {

    private lateinit var binding: FragmentPokemonListBinding
    private lateinit var viewModel: PokeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this).get(PokeListViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pokemon_list, container, false)
        binding.pokeListViewModel = viewModel

        initUI()

        return binding.root
    }

    private fun initUI() {
        pokelistRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        pokelistRecyclerView.adapter = PokeListAdapter{
            val intent = Intent(requireContext(), PokemonDetailFragment::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }

        viewModel.getPokemonList()

        viewModel.pokemonList.observe(viewLifecycleOwner, Observer { list ->
            (pokelistRecyclerView.adapter as PokeListAdapter).setData(list)
        })
    }

}