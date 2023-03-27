package com.nguyencodervn.klad07_navigationjetpack

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    private lateinit var startBt: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startBt = view.findViewById(R.id.startBt)

        // Go to destination by fragment id
        startBt.setOnClickListener {
            val animation = navOptions{
                anim {
                    enter = R.anim.slide_in_right
                    exit = R.anim.slide_out_left
                    popEnter = R.anim.slide_in_left
                    popExit = R.anim.slide_out_right
                }
            }
            findNavController()
                .navigate(R.id.inputFragment,null,animation)
        }
    }
}