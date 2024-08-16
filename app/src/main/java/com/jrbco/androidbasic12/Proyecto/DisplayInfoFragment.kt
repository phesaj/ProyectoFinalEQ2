package com.jrbco.androidbasic12.Proyecto

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jrbco.androidbasic12.R
import com.jrbco.androidbasic12.databinding.FragmentDisplayInfoBinding


class DisplayInfoFragment : Fragment() {

    private lateinit var binding: FragmentDisplayInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDisplayInfoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnLogin.setOnClickListener {

            val user = binding.etWhatcher.text.toString()
            val password = binding.etPassword.text.toString()

            if (user.isNotEmpty()  && password.isNotEmpty()){
                val intent = Intent(requireActivity(),DataUserActivity::class.java).apply {
                    putExtra("USER_KEY", user)
                    putExtra("PASSWORD_KEY", password)
                }
                startActivity(intent)
            }else {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }

        }



        binding.btnRegistrar.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment, UserDataFragment.newInstance())
                .addToBackStack("UserDataFragment")
                .commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = DisplayInfoFragment()
    }
}