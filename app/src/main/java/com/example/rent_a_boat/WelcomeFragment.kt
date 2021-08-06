package com.example.rent_a_boat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rent_a_boat.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogin.setOnClickListener(this)
        binding.buttonRegistration.setOnClickListener(this)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.buttonLogin -> {
                val email = binding.editTextEmail.text.toString()
                val password = binding.editTextPassword.text.toString()

                if (email.isNotBlank() && password.isNotBlank())
                    findNavController()
                        .navigate(R.id.action_welcomeFragment_to_homeFragment)
            }
            binding.buttonRegistration -> {
                findNavController()
                    .navigate(R.id.action_welcomeFragment_to_registerationFragment)
            }
        }
    }
}