package com.github.ehsannarmani.otp.extensions

import androidx.compose.runtime.Composable

@Composable
fun Int.each(block: @Composable (Int) -> Unit) {
    for (i in 0 until this) {
        block(i)
    }
}