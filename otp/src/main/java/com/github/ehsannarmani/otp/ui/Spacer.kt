package com.github.ehsannarmani.otp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Spacer {
    @Composable
    fun SmallSpacer(horizontal: Boolean = false) {
        val size = 4.dp
        return BaseSpacer(size = size, horizontal = horizontal)

    }
    @Composable
    fun MediumSpacer(horizontal: Boolean = false) {
        val size = 8.dp
        return BaseSpacer(size = size, horizontal = horizontal)

    }
    @Composable
    fun LargeSpacer(horizontal: Boolean = false) {
        val size = 16.dp
        return BaseSpacer(size = size, horizontal = horizontal)

    }
    @Composable
    fun VeryLargeSpacer(horizontal: Boolean = false) {
        val size = 32.dp
        return BaseSpacer(size = size, horizontal = horizontal)
    }

    @Composable
    fun BaseSpacer(size:Dp,horizontal: Boolean) {
        return Box(
            modifier = Modifier
                .height(if (horizontal) 0.dp else size)
                .width(if (horizontal) size else 0.dp)
        )
    }
}