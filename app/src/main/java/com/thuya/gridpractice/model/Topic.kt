package com.thuya.gridpractice.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val numberRated: Int,
    @DrawableRes val imageResourceId: Int
)
