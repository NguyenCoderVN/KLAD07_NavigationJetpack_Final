package com.nguyencodervn.klad07_navigationjetpack

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

class MessageFragment : Fragment(R.layout.fragment_message) {
    private lateinit var exitBt: Button
    private lateinit var textView: TextView
    private val args: MessageFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exitBt = view.findViewById(R.id.exitBt)
        textView = view.findViewById(R.id.textView)

        // val text = MessageFragmentArgs.fromBundle(requireArguments()).message
        val text = args.message
        textView.text = getString(R.string.hello, text)

        exitBt.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_messageFragment_to_exitActivity)
        }
    }
}