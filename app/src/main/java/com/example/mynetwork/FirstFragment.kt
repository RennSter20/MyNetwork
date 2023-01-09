package com.example.mynetwork

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.database.Info
import com.example.mynetwork.databinding.FragmentFirstBinding
import com.example.recyclerview.PersonAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      _binding = FragmentFirstBinding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val infoDao = (activity as MainActivity?)?.getDatabase()
        var info: List<Info>
        val infos = binding.recyclerView
        info = infoDao!!.getAll()

        val navController = findNavController()
        val adapter = PersonAdapter(info, navController)

        infos.adapter = adapter
        infos.layoutManager = LinearLayoutManager(requireActivity().applicationContext)

        binding.floatingActionButton.setOnClickListener(){
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
    }
}