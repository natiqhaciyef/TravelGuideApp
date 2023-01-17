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
