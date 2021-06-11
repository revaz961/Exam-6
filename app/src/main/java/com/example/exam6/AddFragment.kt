package com.example.exam6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.children
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.exam6.databinding.FragmentAddBinding
import com.google.android.material.snackbar.Snackbar

class AddFragment : Fragment() {
    private var binding: FragmentAddBinding? = null
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = FragmentAddBinding.inflate(inflater, container, false)
            init()
        }
        return binding!!.root
    }

    private fun init() {
        binding!!.btnAdd.setOnClickListener {
            add()
        }
    }

    private fun add() {
        val title = binding!!.etTitle.text
        val description = binding!!.etDescription.text
        val url = binding!!.etUrl.text
        if (title.length in 6..30 &&
            description.length in 32..300 &&
            url.isNotEmpty()
        ) {
            mainViewModel.write(
                title.toString(), description.toString(), url.toString()
            )
            binding!!.root.children.forEach { if (it is EditText) it.text.clear() }
        } else {
            Snackbar.make(binding!!.root, "enter correct text", Snackbar.LENGTH_LONG).show()
        }
    }
}