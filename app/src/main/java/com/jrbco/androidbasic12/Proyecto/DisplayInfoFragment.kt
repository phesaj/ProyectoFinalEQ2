package com.jrbco.androidbasic12.Proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jrbco.androidbasic12.R
import com.jrbco.androidbasic12.databinding.FragmentDisplayInfoBinding
import com.jrbco.androidbasic12.databinding.FragmentFirstViewbindingBinding
import com.jrbco.androidbasic12.ejercicioclase.ejercicio2.fragment.SecondFragment


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