package com.natiqhaciyef.travelguideapp.data

import android.content.Context
import android.os.Build
import android.text.Html
import android.widget.TextView

fun TextView.switchHtmlToXML(resource: Int, context: Context) =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        this.text = Html.fromHtml(context.getString(resource), Html.FROM_HTML_MODE_COMPACT)
    else
        this.text = Html.fromHtml(context.getString(resource))

fun List<String>.toString(): String {
    var result = ""
    this.forEach {
        result += "$it "
    }
    return result
}

fun String.toCustomList(): List<String> {
    val list = mutableListOf<String>()
    val item = this.toMutableList()
    item.add(' ')
    var temp = ""
    for (i in item) {
        if (i != ' ') {
            temp += i
        } else {
            println(temp)
            list.add(temp)
            temp = ""
        }
    }
    return list
}

fun timesDifferencesCalculator(depTime: String?, retTime: String?): String? {
    if (!depTime.isNullOrEmpty() && !retTime.isNullOrEmpty()) {
        val dh = "${depTime[0]}${depTime[1]}".toInt()
        val dm = "${depTime[3]}${depTime[4]}".toInt()

        val rh = "${retTime[0]}${retTime[1]}".toInt()
        val rm = "${retTime[3]}${retTime[4]}".toInt()

        val calculate = (rh * 60 + rm) - (dh * 60 + dm)
        return "${calculate / 60}h ${calculate % 60}m"
    }else{
        return ""
    }
}

fun timeCalculatorAM(time: String?): String =
    if (!time.isNullOrEmpty()){
    if ("${time[0]}${time[1]}".toInt() > 12 && "${time[0]}${time[1]}".toInt() - 12 >= 10)
        "${("${time[0]}${time[1]}".toInt() - 12)}:${time[3]}${time[4]} PM"
    else if ("${time[0]}${time[1]}".toInt() > 12 && "${time[0]}${time[1]}".toInt() - 12 < 10)
        "0${("${time[0]}${time[1]}".toInt() - 12)}:${time[3]}${time[4]} PM"
    else
        "$time AM"
    }else
        ""