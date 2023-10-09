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

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var edtName: EditText
    private lateinit var edtAddress: EditText
    private lateinit var edtNoHp: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        edtName = view.findViewById(R.id.edt_name)
        edtAddress = view.findViewById(R.id.edt_address)
        edtNoHp = view.findViewById(R.id.edt_nohp)

        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.button -> {

                val bundle = Bundle()
                bundle.putString("name", edtName.text.toString())
                bundle.putString("address", edtAddress.text.toString())
                bundle.putString("nohp", edtNoHp.text.toString())

                var intent = Intent()
                intent = Intent(getActivity(),ResultActivity::class.java)
                        intent.putExtras(bundle)
                        startActivity(intent)
            }
        }
    }
}