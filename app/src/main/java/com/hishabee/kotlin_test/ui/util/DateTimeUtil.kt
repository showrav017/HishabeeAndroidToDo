package com.hishabee.kotlin_test.ui.util

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*

object DateTimeUtil {
    const val apiSubmitDateFormat = "yyyy-MM-dd"
    private const val apiSubmitDateTimeFormat = "yyyy-MM-dd HH:mm:ss"
    const val appViewDateFormat = "dd-MM-yyyy"

    val todayDateForApi: String
        get() {
            val formatter = SimpleDateFormat(apiSubmitDateFormat, Locale.US)
            val date = Date()
            return formatter.format(date)
        }
    val todayDateTimeForApi: String
        get() {
            val formatter = SimpleDateFormat(apiSubmitDateTimeFormat, Locale.US)
            val date = Date()
            return formatter.format(date)
        }
    val todayDateForView: String
        get() {
            val formatter = SimpleDateFormat(appViewDateFormat, Locale.US)
            val date = Date()
            return formatter.format(date)
        }
    val dateFormatForViewWise: String
        get() {
            val formatter = SimpleDateFormat("dd MMMM yyyy, hh:mm a", Locale.US)
            val date = Date()
            return formatter.format(date)
        }
    fun getApiFormattedDate(o: MyDate): String {
        val formatter = SimpleDateFormat(apiSubmitDateFormat, Locale.US)
        val c = Calendar.getInstance()

        c.set(o.year, o.month, o.day)
        return formatter.format(c.time)
    }

    fun getFormattedDate(o: MyDate, apiSubmitDateFormat: String): String {
        val formatter = SimpleDateFormat(apiSubmitDateFormat, Locale.US)
        val c = Calendar.getInstance()

        c.set(o.year, o.month, o.day)
        return formatter.format(c.time)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getGap(from: String, to: String, format: String = "yyyy-MM-dd"): Period {
        val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern(format)

        val from = LocalDate.parse(from, dateFormatter)
        val to = LocalDate.parse(to, dateFormatter)

        val period = Period.between(from, to)
        /*val years = period.years
        val months = period.months
        val days = period.days*/
        return Period.between(from, to)
    }

    //added by Touhid
    fun strToString(
        datetime: String?,
        myDesiredFormat: String?,
        inputPattern: String = "yyyy-MM-dd"
    ): String? {
        //val inputPattern = "yyyy-MM-dd"
        val inputFormat = SimpleDateFormat(inputPattern, Locale.ENGLISH)
        val outputFormat = SimpleDateFormat(myDesiredFormat, Locale.ENGLISH)
        var date: Date? = null
        var str: String? = null
        try {
            date = inputFormat.parse(datetime)
            str = outputFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return str
    }

    fun convertDate(
        datetime: String?,
        myDesiredFormat: String?,
        inputPattern: String = "yyyy-MM-dd"
    ): String {
        //val inputPattern = "yyyy-MM-dd"
        val inputFormat = SimpleDateFormat(inputPattern, Locale.ENGLISH)
        val outputFormat = SimpleDateFormat(myDesiredFormat, Locale.ENGLISH)
        var date: Date? = null
        var str: String? = null
        try {
            date = inputFormat.parse(datetime)
            str = outputFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return str.toString()
    }

    fun showDatePickerDialog(
        context: Context,
        callback: SimpleCallback<MyDate>,
        isToShowFutureDate: Boolean = true,
        isToShowPastDate: Boolean = true,
        minimumStartingDate: Long = (System.currentTimeMillis() - 1000)
    ) {
        val cldr = Calendar.getInstance()
        val day = cldr[Calendar.DAY_OF_MONTH]
        val month = cldr[Calendar.MONTH]
        val year = cldr[Calendar.YEAR]

        val d = DatePickerDialog(
            context, { _, year_, monthOfYear, dayOfMonth ->

                callback.callback(MyDate(dayOfMonth, monthOfYear, year_))
            }, year, month, day
        )

        if (!isToShowFutureDate)
            d.datePicker.maxDate = System.currentTimeMillis()
        if (!isToShowPastDate) {
            d.datePicker.minDate = minimumStartingDate //System.currentTimeMillis() - 1000
        }
        d.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun dateToTimestamp(
        date: String,
        fromPattern: String = "yyyy-MM-dd HH:mm:ss.SSS",
        locale: Locale = Locale.US
    ): Long {
        val dt = DateTimeFormatter.ofPattern(fromPattern, locale)
        val l = LocalDate.parse(date, dt)
        val cal = Calendar.getInstance()
        cal.set(l.year, l.monthValue - 1, l.dayOfMonth)

        return cal.timeInMillis
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun timestampToDate(
        timeStamp: Long,
        toPattern: String = "dd MMMM yyyy hh:mm a",
        locale: Locale = Locale.US
    ): String {
        val formatter = SimpleDateFormat(toPattern, locale)
        val calendar = Calendar.getInstance(Locale.getDefault())
        calendar.timeInMillis = timeStamp
        return formatter.format(calendar.time)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun showDatePickerDialogByCustomDate(
        context: Context,
        callback: SimpleCallback<MyDate>,
        day: Int,
        month: Int,
        year: Int,
        isToShowFutureDate: Boolean = true,
        isToShowPastDate: Boolean = true
    ) {
        val d = DatePickerDialog(
            context, { _, year_, monthOfYear, dayOfMonth ->

                callback.callback(MyDate(dayOfMonth, monthOfYear, year_))
            }, year, month, day
        )

        if (!isToShowFutureDate)
            d.datePicker.maxDate = System.currentTimeMillis()
        if (!isToShowPastDate)
            d.datePicker.minDate = System.currentTimeMillis() - 1000
        d.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getViewFormattedDate(date: String, pattern: String = "yyyy-MM-dd HH:mm:ss.SSS"): String {
        val dt = DateTimeFormatter.ofPattern(pattern, Locale.US)
        val l = LocalDate.parse(date, dt)

        val formatter = SimpleDateFormat(appViewDateFormat, Locale.US)
        val cal = Calendar.getInstance()
        cal.set(l.year, l.monthValue - 1, l.dayOfMonth)

        return formatter.format(cal.time)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getViewFormattedDate(date: MyDate, pattern: String = "dd/MM/yyyy"): String {
        Log.d("DATATAG", "Selected Date$date")

        val dt = DateTimeFormatter.ofPattern(pattern, Locale.US)
        // date.nonth returns month - 1  . so we need to add 1
        val dateStr =
            "${if (date.day < 10) "0${date.day}" else date.day}/${if (date.month > 8) date.month + 1 else "0${date.month + 1}"}/${date.year}"

        Log.d("DATATAG", "Updated Selected Date$dateStr")

        val l = LocalDate.parse(dateStr, dt)

        val formatter = SimpleDateFormat(appViewDateFormat, Locale.US)
        val cal = Calendar.getInstance()
        cal.set(l.year, l.monthValue - 1, l.dayOfMonth)

        return formatter.format(cal.time)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun dateFormatFromTo(
        date: String,
        fromPattern: String = "yyyy-MM-dd HH:mm:ss.SSS",
        toPattern: String = "yyyy-MM-dd HH:mm:ss.SSS",
        locale: Locale = Locale.US
    ): String {
        val dt = DateTimeFormatter.ofPattern(fromPattern, locale)
        val l = LocalDate.parse(date, dt)

        val formatter = SimpleDateFormat(toPattern, locale)
        val cal = Calendar.getInstance()
        cal.set(l.year, l.monthValue - 1, l.dayOfMonth)

        return formatter.format(cal.time)
    }

}

data class MyDate(val day: Int, val month: Int, val year: Int)

interface SimpleCallback<T> {
    fun callback(o: T)
}