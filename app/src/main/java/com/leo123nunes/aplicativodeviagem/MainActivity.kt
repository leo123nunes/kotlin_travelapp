package com.leo123nunes.aplicativodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
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
            when{
                editDistance.text.toString()==""||editDistance.text.toString().startsWith("0") -> Toast.makeText(this,"O campo distancia não pode estar em branco.",Toast.LENGTH_LONG).show()
                editPrice.text.toString()==""||editPrice.text.toString().startsWith("0") -> Toast.makeText(this,"O campo preço não pode estar em branco.",Toast.LENGTH_LONG).show()
                editAutonomy.text.toString()==""||editAutonomy.text.toString().startsWith("0") -> Toast.makeText(this,"O campo autonomia não pode estar em branco.",Toast.LENGTH_LONG).show()
                else -> {
                    val distance = editDistance.text.toString().toFloat()
                    val price = editPrice.text.toString().toFloat()
                    val autonomy = editAutonomy.text.toString().toFloat()

                    val total = (distance*price)/autonomy

                    totalPrice.text = "R$ ${"%.2f".format(total)}"
                }
            }

        }else{
                Toast.makeText(this,"Por gentileza, preencha todos os campos.",Toast.LENGTH_LONG).show()
        }
    }

    private fun validateInput(): Boolean{
        return editDistance.text.toString()!=""&&
                editPrice.text.toString()!=""&&
                editAutonomy.text.toString()!=""
    }
}



