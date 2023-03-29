package com.nguyencodervn.klad07_navigationjetpack

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AboutDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.nguyencodervn))
            .setPositiveButton(getString(R.string.ok)) { _,_ -> }
            .setCancelable(false)
            .create()
}