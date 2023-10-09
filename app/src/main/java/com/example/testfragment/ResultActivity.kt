package com.example.testfragment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class ResultActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvName: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvNoHp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvName = findViewById(R.id.tv_name)
        tvAddress = findViewById(R.id.tv_address)
        tvNoHp = findViewById(R.id.tv_nohp)

        val intent = getIntent()

        val name = intent.getParcelableExtra<User>("User")?.name
        val address = intent.getParcelableExtra<User>("User")?.address
        val nohp = intent.getParcelableExtra<User>("User")?.nohp

        tvName.text = "Nama : $name"
        tvAddress.text = "Alamat : $address"
        tvNoHp.text = "Nomor Telp : $nohp"

        val bundle = intent.extras
        if (bundle != null) {
            tvName.setText(bundle.getString("name"))
            tvAddress.setText(bundle.getString("address"))
            tvNoHp.setText(bundle.getString("nohp"))
        }
        val btnEdit: Button = findViewById(R.id.button3)
        btnEdit.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.button3 -> {

                val bundle = Bundle()
                bundle.putString("name", tvName.text.toString())
                bundle.putString("address", tvAddress.text.toString())
                bundle.putString("nohp", tvNoHp.text.toString())

                val intent = Intent(this@ResultActivity, HomeFragment::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}