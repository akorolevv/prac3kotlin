package com.example.prac3kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.prac3kotlin.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToThird.setOnClickListener {
            sharedViewModel.onNavigateToThird()
        }

        binding.buttonBackToFirst.setOnClickListener {
            findNavController().navigateUp()
        }

        sharedViewModel.navigateToThird.observe(viewLifecycleOwner) { shouldNavigate ->
            if (shouldNavigate) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, ThirdFragment())
                    .addToBackStack(null)
                    .commit()
                sharedViewModel.onNavigationComplete()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}