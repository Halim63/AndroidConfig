package com.example.androidbykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

val egyptianPound = "Egyptian Pound"
val americanDollar = "American Dollar"
val AED = "AED"
val GBP = "GBP"

val values = mapOf(
    egyptianPound to 23.0,
    americanDollar to 1.0,
    AED to 20.0,
    GBP to 10.0
)

lateinit var converterBtn: Button
lateinit var amountEt: TextInputEditText
lateinit var resultEt: TextInputEditText
lateinit var toMenu: AutoCompleteTextView
lateinit var fromMenu: AutoCompleteTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(baseContext,"onCreate",Toast.LENGTH_SHORT).show()

        initView()
        populateDropDownMenu()

        converterBtn.setOnClickListener {
            calculateResult()
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(baseContext,"onStart",Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(baseContext,"onResume",Toast.LENGTH_SHORT).show()

    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(baseContext,"onPause",Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(baseContext,"onStop",Toast.LENGTH_SHORT).show()

    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(baseContext,"onRestart",Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(baseContext,"onDestroy",Toast.LENGTH_SHORT).show()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putStringArray("drop", arrayOf(arrayOf(values).toString()))
        super.onSaveInstanceState(outState)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        var result=savedInstanceState.getString("drop")
        from_menu.setText(result)
        to_menu.setText(result)

    }

    private fun calculateResult() {
        if (amountEt.text.toString().isNotEmpty()) {
            val amount = amountEt.text.toString().toDouble()
            val toValue = values[toMenu.text.toString()]
            val fromValue = values[fromMenu.text.toString()]
            val result = amount.times(toValue!!.div(fromValue!!))
            resultEt.setText(result.toString())
        } else {
//                  Toast.makeText(this,"please enter the amount",Toast.LENGTH_SHORT).show()
            amountEt.setError("Amount Empty")
        }
    }

    private fun populateDropDownMenu() {
        val listOfCountry = listOf(egyptianPound, americanDollar, AED, GBP)
        val adapter = ArrayAdapter(this, R.layout.drop_down_list_view, listOfCountry)
        toMenu.setAdapter(adapter)
        fromMenu.setAdapter(adapter)

    }

    fun initView() {
        converterBtn = findViewById(R.id.button)
        amountEt = findViewById(R.id.amount_et)
        resultEt = findViewById(R.id.result_et)
        toMenu = findViewById(R.id.to_menu)
        fromMenu = findViewById(R.id.from_menu)
    }
}