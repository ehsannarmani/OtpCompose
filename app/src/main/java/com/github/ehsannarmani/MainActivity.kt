package com.github.ehsannarmani

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ehsannarmani.otp.ui.Otp
import com.github.ehsannarmani.ui.theme.OtpComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OtpComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val successColor = Color(0xff17917a)
                    val errorColor = Color(0xFFFF6969)

                    var error by remember {
                        mutableStateOf(false)
                    }
                    var success by remember {
                        mutableStateOf(false)
                    }

                    val bgColor by animateColorAsState((if (success) successColor else if (error) errorColor else Color.White).copy(alpha = .2f))

                    Box(modifier=Modifier.fillMaxSize().background(bgColor), contentAlignment = Alignment.Center){
                        Otp(
                            count = 5,
                            error = error,
                            success = success,
                            errorColor = errorColor,
                            successColor = successColor,
                            focusedColor = Color(0xff313131),
                            unFocusedColor = Color.Gray,
                            onFinish = { otp->
                                if(otp == "12345"){
                                    success = true
                                    error = false
                                }else{
                                    success = false
                                    error = true
                                }
                            },
                            modifier=Modifier.size(60.dp,90.dp),
                        )
                    }
                }
            }
        }
    }
}

