package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
            
        }
    }

    fun clickDatePicker(view: View?) {

        val myCalendar = Calendar.getInstance()
        val selectedYear = myCalendar.get(Calendar.YEAR)
        val selectedMonth = myCalendar.get(Calendar.MONTH)
        val selectedDay = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth ->
                Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show()

                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                tvSelectedDate.setText(selectedDate)
                
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)

            }
            ,selectedYear
            ,selectedMonth
            ,selectedDay).show()
    }
}