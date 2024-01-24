package com.anehta.bottomsheetdialogtest

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.FrameMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.graphics.createBitmap
import com.anehta.bottomsheetdialogtest.databinding.ModalBottomSheetContentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding : ModalBottomSheetContentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ModalBottomSheetContentBinding.inflate(inflater,container,false)
        return binding.root
    }
    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bottomDialog.setOnShowListener { dialog: DialogInterface ->
            if (dialog is BottomSheetDialog) {
                dialog.findViewById<FrameLayout>(R.id.standard_bottom_sheet)?.let { bottomSheet ->
                    val bottomSheetBehavior: BottomSheetBehavior<*> =
                        BottomSheetBehavior.from<FrameLayout?>(bottomSheet)
                    bottomSheetBehavior.setPeekHeight(Int.MAX_VALUE)
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            }


        }
        return bottomDialog
    }
}