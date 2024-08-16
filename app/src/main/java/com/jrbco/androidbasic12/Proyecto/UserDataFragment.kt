package com.jrbco.androidbasic12.Proyecto

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jrbco.androidbasic12.R
import com.jrbco.androidbasic12.databinding.FragmentDisplayInfoBinding
import com.jrbco.androidbasic12.databinding.FragmentUserDataBinding


class UserDataFragment : Fragment() {

    private lateinit var binding: FragmentUserDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDataBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCreateUser.setOnClickListener {

            val user = binding.etUser.text.toString()
            val password = binding.etPassword.text.toString()
            val conpass = binding.etPassword1.text.toString()
            val name = binding.etName.text.toString()
            val surname = binding.etSecondN.text.toString()
            val email = binding.etEmail.text.toString()

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.error = "Correo electrónico no válido"
                return@setOnClickListener
            }

            if (user.isNotEmpty()  && password.isNotEmpty() && conpass.isNotEmpty() && name.isNotEmpty() && surname.isNotEmpty() && email.isNotEmpty()){

                if (password == conpass){
                    val intent = Intent(requireActivity(),DataUserActivity::class.java).apply {
                        putExtra("USER_KEY", user)
                        putExtra("PASSWORD_KEY", password)
                        putExtra("NAME_KEY", name)
                        putExtra("SURNAME_KEY", surname)
                        putExtra("EMAIL_KEY", email)
                    }
                    startActivity(intent)
                }else {
                    Toast.makeText(requireContext(), "La contraseña no es igual", Toast.LENGTH_SHORT).show()
                }

            }else {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }

        }

    }


    companion object {

        @JvmStatic
        fun newInstance() = UserDataFragment()
    }
}