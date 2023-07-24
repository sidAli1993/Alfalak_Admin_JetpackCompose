package com.example.al_falakmain.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.al_falakmain.ui.components.ButtonSimple
import com.example.al_falakmain.ui.components.EditTextCustom
import com.example.al_falakmain.ui.components.EditTextCustomPassword
import com.example.al_falakmain.ui.routes.Routes
import com.example.al_falakmain.ui.theme.AlFalakMainTheme
import com.example.al_falakmain.ui.theme.White

@Composable
fun LoginPage(navHostController: NavHostController) {
    AlFalakMainTheme() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
        ) {

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp)
            ) {
                Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(5.dp)

                        .align(Alignment.CenterHorizontally)
                        .size(50.dp), painter = painterResource(
                        id = com.example.al_falakmain.R.drawable.ic_fingerprint
                    ), contentDescription = "Fingerprint Icon"
                )
                ClickableText(
                    text = AnnotatedString("Sign In Here"),
                    onClick = {
                        navHostController.navigate(Routes.SignUp.route)
                    },
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                    ),
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                Image(
                    painter = painterResource(id = com.example.al_falakmain.R.drawable.topbar_back),
                    contentDescription = "background dots"
                )
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    modifier = Modifier
                        .height(50.dp)
                        .padding(start = 15.dp, end = 15.dp)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = com.example.al_falakmain.R.drawable.splash_logo),
                    contentDescription = "logo"
                )
            }
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.Center)
                    .background(White),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val username = remember {
                    mutableStateOf("")
                }
                val password = remember {
                    mutableStateOf("")
                }

                Text(
                    text = "Login To Alfalak-Admin",
                    style = TextStyle(
fontFamily = FontFamily.SansSerif,
                        fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                    ),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier.padding(horizontal = 16.dp),horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                    Image(modifier = Modifier.size(width = 30.dp, height = 30.dp),painter = painterResource(id = com.example.al_falakmain.R.drawable.ic_lock), contentDescription = "")
                    EditTextCustom( value = username.value,
                        onValueChanged = { username.value = it },
                        placeholder = "UserName",

                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                EditTextCustomPassword(
                    value = password.value,
                    onValueChanged = { password.value = it },
                    placeholder = "Password",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.padding(start = 46.dp, end = 16.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))
                ButtonSimple(text = "Login"
                    , modifier = Modifier.padding(start = 50.dp, end = 50.dp)
                    , onClick = {
                        navHostController.navigate("dashboard_screen")
                    }
                )
//
                Spacer(modifier = Modifier.height(20.dp))

                ClickableText(
                    text = AnnotatedString("Forgot Password"), onClick = {
                        navHostController.navigate(Routes.ForgotPassword.route)
                    }, style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp
                    )
                )
            }

        }
    }

}

@Composable
@Preview
fun LoginScreenPreview() {
    AlFalakMainTheme() {
        LoginPage(navHostController = rememberNavController())

    }

}



