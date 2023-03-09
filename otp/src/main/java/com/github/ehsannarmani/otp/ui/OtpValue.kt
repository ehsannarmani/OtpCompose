package com.github.ehsannarmani.otp.ui

import androidx.compose.ui.focus.FocusRequester

data class OtpValue(
    val value: String = "",
    var focused: Boolean = false,
    val focusRequester: FocusRequester? = null,
)