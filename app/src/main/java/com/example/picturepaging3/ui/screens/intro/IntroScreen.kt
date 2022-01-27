package com.example.picturepaging3.ui.screens.intro

import android.view.animation.OvershootInterpolator
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.picturepaging3.R
import com.example.picturepaging3.ui.navigation.Screen
import com.example.picturepaging3.ui.screens.common.Loader
import kotlinx.coroutines.delay

@Composable
fun IntroScreen(navController: NavHostController) {

    val scale = remember { Animatable(0f) }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.2f,
            animationSpec = tween(
                durationMillis = 5000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(10L)
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Intro.route) { inclusive = true }
            launchSingleTop = true
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Loader(R.raw.intro_anim)
        Text(
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}