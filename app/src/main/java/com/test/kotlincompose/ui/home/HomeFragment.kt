package com.test.kotlincompose.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.kotlincompose.adapter.HomeAdapter
import com.test.kotlincompose.databinding.FragmentHomeBinding
import com.test.kotlincompose.entity.HomeEntity
import kotlin.reflect.KClass

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val adapter by lazy {
        HomeAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initViewData()


        homeViewModel.recyclerviewData.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
        return root
    }

    private fun initViewData() {

        val recyclerview = binding.recyclerview
        recyclerview.layoutManager = LinearLayoutManager(context)

        adapter.setOnItemClickListener { adapter, _, position ->
            val item = adapter.data[position] as HomeEntity

            /*内联函数*/
            startActivity(Intent(requireContext(), item.activity))
        }

        recyclerview.adapter = adapter


    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}