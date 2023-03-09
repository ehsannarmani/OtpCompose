package com.github.ehsannarmani.otp.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OtpBox(
    modifier: Modifier,
    otpValue: OtpValue,
    onValueChange: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    onBackSpace: () -> Unit,
    textStyle: TextStyle = TextStyle(
        fontSize = 25.sp, textAlign = TextAlign.Center
    ),
    onFocusSet: (FocusRequester) -> Unit,
    successColor: Color = Color(0xffffffff),
    errorColor: Color = Color(0xffffffff),
    focusedColor: Color = MaterialTheme.colors.secondary,
    cursorColor: Color = MaterialTheme.colors.secondary,
    unFocusedColor: Color = Color.Gray,
    error: Boolean,
    success: Boolean
) {
    val focusRequester = remember {
        FocusRequester()
    }
    LaunchedEffect(Unit) {
        onFocusSet(focusRequester)
    }
    val color by animateColorAsState(
        targetValue = if (error)
            errorColor
        else if (success)
            successColor
        else if (otpValue.focused)
            focusedColor
        else
            unFocusedColor,
        animationSpec = tween(300)
    )
    val textColor by animateColorAsState(
        targetValue = if (otpValue.focused) focusedColor else unFocusedColor,
        animationSpec = tween(300)
    )
    Box(
        modifier = modifier
            .border((1.5).dp, color, RoundedCornerShape(8))
            .size(50.dp, 70.dp),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            modifier = Modifier
                .focusRequester(focusRequester)
                .onFocusChanged { onFocusChanged(it.isFocused) }
                .onKeyEvent {
                    if (it.key.keyCode == Key.Backspace.keyCode) {
                        onBackSpace()
                    }
                    false
                },
            value = otpValue.value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            textStyle = textStyle.copy(color = textColor),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = cursorColor
            ),
            )
    }
}