package org.hyperskill.musicplayer.presentation

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.hyperskill.musicplayer.R
import org.hyperskill.musicplayer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViewModel()
        initMainPlayerControllerFragment()
        initListeners()

        lifecycleScope.launch {
            viewModel.uiState.collect(::handleUiState)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mainMenuAddPlaylist -> {
                val errorString = "no songs loaded, click search to load songs"
                if (errorString.isNotEmpty()) Toast.makeText(
                    this, errorString,
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.mainMenuLoadPlaylist, R.id.mainMenuDeletePlaylist -> {
                AlertDialog.Builder(this)
                    .setTitle(
                        "choose playlist to ${
                            if (item.itemId == R.id.mainMenuLoadPlaylist) "load"
                            else "delete"
                        }"
                    )
                    .setNegativeButton(
                        android.R.string.cancel, null
                    )
                    .show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initMainPlayerControllerFragment() {
        val mainPlayerControllerFragment = MainPlayerControllerFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFragmentContainer, mainPlayerControllerFragment, null)
            commit()
        }
    }

    private fun initListeners() {
        binding.mainButtonSearch.setOnClickListener {
            Toast.makeText(
                this, "no songs found",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun handleUiState(uiState: MainViewModel.UiState) {
        when (uiState) {

            MainViewModel.UiState.AddPlaylist -> {

            }

            MainViewModel.UiState.PlayMusic -> {

            }
        }
    }
}
