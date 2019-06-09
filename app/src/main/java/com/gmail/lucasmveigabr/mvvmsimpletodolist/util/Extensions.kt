package com.gmail.lucasmveigabr.mvvmsimpletodolist.util

import android.content.Context
import android.os.Build
import android.widget.TextView
import androidx.cardview.widget.CardView

fun TextView.setColor(colorRes: Int, context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        this.setTextColor(context.resources.getColor(colorRes, context.theme))
    } else {
        this.setTextColor(context.resources.getColor(colorRes))
    }
}

fun CardView.setColor(colorRes: Int, context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        this.setCardBackgroundColor(context.resources.getColor(colorRes, context.theme))
    } else {
        this.setCardBackgroundColor(context.resources.getColor(colorRes))
    }
}