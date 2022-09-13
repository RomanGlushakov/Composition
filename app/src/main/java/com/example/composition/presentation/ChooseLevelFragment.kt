package com.example.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.composition.R

import com.example.composition.databinding.FragmentChooseLevelBinding
import com.example.composition.domain.entity.Level

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonTestLevel.setOnClickListener {
            launchGameWithChosenLevel(Level.TEST)
        }

        binding.buttonEasyLevel.setOnClickListener {
            launchGameWithChosenLevel(Level.EASY)
        }

        binding.buttonNormalLevel.setOnClickListener {
            launchGameWithChosenLevel(Level.NORMAL)
        }

        binding.buttonHardLevel.setOnClickListener {
            launchGameWithChosenLevel(Level.HARD)
        }
    }

    private fun launchGameWithChosenLevel(level: Level) {
        findNavController().navigate(
            ChooseLevelFragmentDirections.
            actionChooseLevelFragmentToGameFragment(level))

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}