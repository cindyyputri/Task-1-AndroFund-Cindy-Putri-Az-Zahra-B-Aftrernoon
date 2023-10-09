package com.example.testfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

class DataFragment : Fragment(), View.OnClickListener {
    private lateinit var edtHeight: EditText
    private lateinit var edtWeight: EditText

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_data, container, false)
        edtHeight = view.findViewById(R.id.edt_height)
        edtWeight = view.findViewById(R.id.edt_weight)

        val button = view.findViewById<Button>(R.id.button2)
        button.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.button -> {
                findNavController().navigate(R.id.action_homeFragment_to_dataFragment)

                val bundle = Bundle()
                bundle.putString("name", edtHeight.text.toString())
                bundle.putString("address", edtWeight.text.toString())

                var intent = Intent()
                intent = Intent(getActivity(),ResultActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }


}