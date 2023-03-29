package com.nguyencodervn.klad07_navigationjetpack

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class InputFragment : Fragment(R.layout.fragment_input) {
    private lateinit var inputEt : EditText
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputEt = view.findViewById(R.id.inputEt)
        view.findViewById<Button>(R.id.submitBt)
            .setOnClickListener {
                val input = inputEt.text.toString()
                if (input.isEmpty()) {
                    Toast.makeText(context,
                    getString(R.string.input),
                    Toast.LENGTH_LONG).show()
                } else {
                    val action = InputFragmentDirections.actionToMessageFragment(input)
                    findNavController().navigate(action)
                }

            }
    }
}