package com.nguyencodervn.klad07_navigationjetpack

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    private lateinit var startBt: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startBt = view.findViewById(R.id.startBt)
        startBt.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_welcomeFragment_to_inputFragment)
        }
    }
}