package com.example.exam6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.exam6.databinding.FragmentArticleBinding


class ArticleFragment : Fragment() {
    private var binding: FragmentArticleBinding? = null
    private var adapter: ArticleAdapter? = null
    private val articleViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = FragmentArticleBinding.inflate(inflater, container, false)
            init()
        }
        return binding!!.root
    }

    private fun init() {
        binding!!.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_articleFragment_to_addFragment)
        }

        initRecycler()
        observes()
    }


    private fun initRecycler() {
        adapter = ArticleAdapter({
            articleViewModel.update(it)
        }) {
            articleViewModel.delete(it)
        }
    binding!!.rvUsers.adapter = adapter
    binding!!.rvUsers.layoutManager = GridLayoutManager(requireContext(), 1)
}

private fun observes() {
    articleViewModel._userLiveData.observe(viewLifecycleOwner, {
        adapter!!.setUsers(it)
    })
}
}