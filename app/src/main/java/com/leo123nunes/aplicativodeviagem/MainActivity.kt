package com.leo123nunes.aplicativodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if(id==R.id.buttonCalculate){
            calculate()
        }
    }

    private fun calculate(){
        if(validateInput()){
            val distance = editDistance.text.toString().toFloat()
            val price = editPrice.text.toString().toFloat()
            val autonomy = editAutonomy.text.toString().toFloat()

            val total = (distance*price)/autonomy

            totalPrice.text = "R$ ${"%.2f".format(total)}"
        }
    }

    private fun validateInput(): Boolean{
        return editDistance.text.toString()!=""&&
                editPrice.text.toString()!=""&&
                editAutonomy.text.toString()!=""
    }
}



