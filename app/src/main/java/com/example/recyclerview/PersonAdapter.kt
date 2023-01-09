package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.database.Info
import com.example.mynetwork.EditInfoFragment
import com.example.mynetwork.R

class PersonAdapter(private val infos: List<Info>, navController: NavController) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    var navControllerThis: NavController = navController

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val personFullName = itemView.findViewById<TextView>(R.id.person_full_name)
        val editButton = itemView.findViewById<Button>(R.id.buttonEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val person = inflater.inflate(R.layout.item_person, parent, false)
        return ViewHolder(person)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact: Info = infos.get(position)
        val textView = holder.personFullName
        textView.setText(contact.firstName + " " + contact.lastName)
        val button = holder.editButton

        button.setOnClickListener(){
            val bundle = bundleOf("personID" to infos.get(position).uid)
            Log.i("ADAPTER ID", infos.get(position).uid.toString())
            navControllerThis.navigate(R.id.action_FirstFragment_to_editInfoFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return infos.size
    }

}