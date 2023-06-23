package com.hishabee.kotlin_test.ui.util

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.Toast
import com.hishabee.kotlin_test.ui.base.BaseActivity
import com.hishabee.kotlin_test.ui.main.MainActivity
import java.text.SimpleDateFormat
import java.util.*

fun Context.showToast(text: String, time: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, text, time).show()

fun Context.datePicker(onDatePick: (code: String) -> Unit): DatePickerDialog {
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val now = Calendar.getInstance()
    mYear = now.get(Calendar.YEAR)
    mMonth = now.get(Calendar.MONTH)
    mDay = now.get(Calendar.DAY_OF_MONTH)
    now.time = Date()
    return DatePickerDialog(
        this,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val cal = Calendar.getInstance()
            cal.set(year, month, dayOfMonth)
            onDatePick(SimpleDateFormat("dd-MM-yyyy").format(cal.time))
        }, mYear, mMonth, mDay
    )
}

