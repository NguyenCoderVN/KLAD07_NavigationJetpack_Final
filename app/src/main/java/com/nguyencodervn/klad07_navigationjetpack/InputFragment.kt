package com.nguyencodervn.klad07_navigationjetpack

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class InputFragment : Fragment(R.layout.fragment_input) {
    private lateinit var submitBt: Button
    private lateinit var inputEt: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitBt = view.findViewById(R.id.submitBt)
        inputEt = view.findViewById(R.id.inputEt)

        submitBt.setOnClickListener {
            val input = inputEt.text.toString()
            val action = InputFragmentDirections
                .actionInputFragmentToMessageFragment(input)
            if (input.isEmpty()) {
                Toast.makeText(
                    context,
                    getString(R.string.hello),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                view.findNavController().navigate(action)
            }
        }
    }
}