package com.example.exercise1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(){
            clickHandlerFunction(it)


        }


    }

    private fun clickHandlerFunction(view: View) {
        val carPrice:Double = ptxtCarPrice.text.toString().toDouble()
        val downPayment:Double = ptxtDownPayment.text.toString().toDouble()
        val interestRate:Double = ptxtInterestRate.text.toString().toDouble()
        val loanPeriod:Double = ptxtLoanPeriod.text.toString().toDouble()

        val carLoan:Double = carPrice - downPayment
        val interest:Double = carLoan * interestRate * loanPeriod
        val monthlyRepayment:Double = (carLoan + interest) / loanPeriod / 12

        txtvCarLoanResult.text = carLoan.toString()
        txtvInterestResult.text = interest.toString()
        txtvMonthlyRepaymentResult.text = monthlyRepayment.toString()

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
