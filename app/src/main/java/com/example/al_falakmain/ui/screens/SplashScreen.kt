package com.example.al_falakmain.ui.screens

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.al_falakmain.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController
) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        navHostController.navigate("login")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
    ) {
        Image(
            painter = painterResource(id = com.example.al_falakmain.R.drawable.background_two),
            contentDescription = "SPlash screen",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = com.example.al_falakmain.R.drawable.splash_two),
            contentDescription = "Logo", modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                .align(Alignment.Center)
        )
    }
}