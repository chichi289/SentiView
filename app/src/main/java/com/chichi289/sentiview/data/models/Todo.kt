package com.chichi289.sentiview.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
) : Parcelable
