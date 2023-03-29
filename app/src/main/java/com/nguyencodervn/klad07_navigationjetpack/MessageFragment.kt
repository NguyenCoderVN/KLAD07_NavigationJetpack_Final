package com.nguyencodervn.klad07_navigationjetpack

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class MessageFragment : Fragment(R.layout.fragment_message) {
    private val args : MessageFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = args.message
        view.findViewById<TextView>(R.id.textView).text =
            getString(R.string.hello, text)
    }
}