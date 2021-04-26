package co.cyclopsapps.mvvmpokedex.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import co.cyclopsapps.mvvmpokedex.R
import co.cyclopsapps.mvvmpokedex.databinding.ActivityMainBinding
import co.cyclopsapps.mvvmpokedex.viewmodels.PokeListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private lateinit var viewModel: PokeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //viewModel = ViewModelProvider(this).get(PokeListViewModel::class.java)

        setContentView(binding.root)
    }
}