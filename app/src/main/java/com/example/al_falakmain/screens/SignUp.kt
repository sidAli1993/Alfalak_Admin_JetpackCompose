package com.example.alfalakandroidapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.al_falakmain.components.CustomTopAppBar

@Composable
fun SignUpPage(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        ScaffoldWithTopBar(navHostController = navHostController)
    }
}

@Composable
fun ScaffoldWithTopBar(navHostController: NavHostController) {
//    Scaffold(
//        topBar = {
//            CustomTopAppBar(
//                navController = navHostController,
//                title = "Sign Up",
//                showBackIcon = true,
//                showRightIcon = false
//            )
//        },
//        content = {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "Sign Up",
//                    fontSize = 30.sp,
//                    color = Color.Black
//                )
//            }
//        }
//    )
}