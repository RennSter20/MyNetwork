package com.example.mynetwork

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.database.Database
import com.example.database.Info
import com.example.mynetwork.databinding.FragmentSecondBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

private var _binding: FragmentSecondBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      _binding = FragmentSecondBinding.inflate(inflater, container, false)
      return binding.root

    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val infoDao = (activity as MainActivity?)?.getDatabase()

        var users: List<Info> = infoDao!!.getAll()

        var a:Int = 0
        a++
        binding.button.setOnClickListener(){
            var newInfo:Info = Info(users.size,
                binding.inputTextFirstName.text.toString(),
                binding.inputTextLastName.text.toString(),
                binding.inputTextPhone.text.toString(),
                binding.inputTextAddress.text.toString(),
                binding.inputTextWork.text.toString(),
                binding.inputTextEducation.text.toString(),
                binding.inputTextCustomFirst.text.toString(),
                binding.inputTextCustomFirst.text.toString(),
                binding.inputTextOther.text.toString())
            infoDao.insertAll(newInfo)
            users = infoDao.getAll()
            a++
        }

    }
override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}