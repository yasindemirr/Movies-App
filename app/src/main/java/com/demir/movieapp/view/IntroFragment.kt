package com.demir.movieapp.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.demir.movieapp.R
import com.demir.movieapp.databinding.FragmentIntroBinding
import com.demir.movieapp.databinding.FragmentMainBinding

class IntroFragment : Fragment() {
private lateinit var binding: FragmentIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=FragmentIntroBinding.inflate(layoutInflater,container,false)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_introFragment_to_mainFragment)
        },3000)
        return binding.root
    }


}