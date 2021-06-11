package com.example.exam6

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Article(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String?,
    val description: String?,
    val url: String?
) : Parcelable {
    constructor(
        title: String?,
        description: String?,
        url: String?
    ) : this(
        0, title,
        description,
        url
    )
}
