package org.hyperskill.musicplayer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.hyperskill.musicplayer.databinding.FragmentMainPlayerBinding

class MainPlayerControllerFragment : Fragment() {

    private var _binding: FragmentMainPlayerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }
}
