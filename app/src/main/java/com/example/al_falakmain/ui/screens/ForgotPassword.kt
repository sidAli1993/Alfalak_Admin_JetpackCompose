package com.example.al_falakmain.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.al_falakmain.ui.components.CustomTopAppBar

@Composable
fun ForgotPasswordPage(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        ScaffoldWithTopBarForgotPass(navHostController = navHostController)
    }
}
@Composable
fun ScaffoldWithTopBarForgotPass(navHostController: NavHostController) {
//    Scaffold(topBar = {
//        CustomTopAppBar(
//            navController = navHostController,
//            title = "Forgot Password",
//            showBackIcon = true,
//            showRightIcon = false
//        )
//    },
//
//        content = {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(text = "Forgot Password", fontSize = 30.sp, color = Color.Black)
//            }
//        })
}