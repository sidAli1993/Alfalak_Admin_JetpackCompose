package com.example.al_falakmain.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.al_falakmain.R
import com.example.al_falakmain.ui.components.ButtonSimple
import com.example.al_falakmain.ui.components.CircleImageView
import com.example.al_falakmain.ui.routes.Routes
import com.example.al_falakmain.ui.theme.AlFalakMainTheme
import com.example.al_falakmain.ui.theme.Black
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.DarkGray
import com.example.al_falakmain.ui.theme.DarkGreen
import com.example.al_falakmain.ui.theme.LightGray
import com.example.al_falakmain.ui.theme.White

@Composable
fun SummaryScreen(navHostController: NavHostController) {
    AlFalakMainTheme() {
        Scaffold() {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(White)
                    .padding(bottom = 20.dp)
            ) {
                val customerName = remember {
                    mutableStateOf("Mirza Ali")
                }

                Image(
                    painter = painterResource(id = R.drawable.topbar_back),
                    contentDescription = "back Image",
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    painter = painterResource(id = R.drawable.splash_logo),
                    contentDescription = "Logo", modifier = Modifier
                        .padding(top = 100.dp, start = 50.dp, end = 50.dp)
                        .height(50.dp)
                        .align(Alignment.TopCenter)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 200.dp, start = 16.dp, end = 16.dp)
                        .align(Alignment.TopCenter),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Cash in Hand : 100000 CR",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 16.sp,
                            color = White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                            )
                            .background(BlueDark)
                            .padding(10.dp),


                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(DarkGray, LightGray),
                                    startY = 0f,
                                    endY = 300f // Adjust the endY value to control the gradient spread
                                )
                            )
                            )
                    {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp)) {
                            Text(
                                text = "Order Id",
                                style = TextStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 16.sp,
                                    color = Black
                                ),
                                modifier = Modifier
                                    .padding(top=10.dp, start = 10.dp),
                            )
                            Text(
                                text = "8906",
                                style = TextStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 20.sp,
                                    color = DarkGreen
                                ),
                                modifier = Modifier
                                    .padding(top=10.dp, start = 10.dp),
                            )
                            Row(modifier = Modifier.padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly) {
                                Text(
                                    text = "Customer Name:",
                                    style = TextStyle(
                                        fontWeight = FontWeight.SemiBold,
                                        fontFamily = FontFamily.SansSerif,
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    ),
                                    modifier = Modifier
                                        .width(130.dp)
                                        .padding(end = 15.dp)
                                )
                                Text(
                                    text = customerName.value,
                                    style = TextStyle(
                                        fontWeight = FontWeight.SemiBold,
                                        fontFamily = FontFamily.SansSerif,
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    ),
                                    modifier = Modifier
                                )
                            }

                            Row(modifier = Modifier.padding(start = 10.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly) {
                                Text(
                                    text = "Liters :200",
                                    style = TextStyle(
                                        fontWeight = FontWeight.SemiBold,
                                        fontFamily = FontFamily.SansSerif,
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    ),
                                    modifier = Modifier
                                        .width(130.dp)
                                        .padding(end = 15.dp)
                                )
                                Text(
                                    text = "5000.00",
                                    style = TextStyle(
                                        fontWeight = FontWeight.SemiBold,
                                        fontFamily = FontFamily.SansSerif,
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    ),
                                    modifier = Modifier
                                )
                            }
                            CircleImageView(modifier = Modifier
                                .size(50.dp)
                                .align(Alignment.End)
                                .padding(end = 10.dp),
                                imageId = R.drawable.ic_person, )
                            Text(
                                text = "By: Asif Bhatti",
                                style = TextStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 14.sp,
                                    color = Color.Black
                                ),
                                modifier = Modifier
                            )
                            Row(modifier =
                                Modifier.fillMaxWidth()
                                ,
                                horizontalArrangement = Arrangement.End) {
                                Box(modifier = Modifier
                                    .width(100.dp)
                                    .height(60.dp)
                                ) {
                                    Image(modifier = Modifier
                                        .width(50.dp)
                                        .height(40.dp),painter = painterResource(id = R.drawable.approved), contentDescription ="" )
                                    Image(modifier = Modifier
                                        .width(80.dp)
                                        .height(40.dp),painter = painterResource(id = R.drawable.signature), contentDescription ="" )

                                }
                            }


                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                                horizontalArrangement = Arrangement.End,
                            ) {
                                Button(onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .height(30.dp)
                                        .width(60.dp)
                                        .clip(RoundedCornerShape(15.dp))
                                        .padding(3.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = BlueDark,
                                        contentColor = White
                                    )
                                ) {
                                    Text(text = "Save",
                                    style = TextStyle(
                                        fontSize = 9.sp,
                                        fontFamily = FontFamily.SansSerif,
                                    )
                                    )

                                }
                                Button(onClick = { navHostController.navigate(Routes.CashPaymentScreen.route) },
                                    modifier = Modifier
                                        .height(30.dp)
                                        .width(60.dp)

                                        .clip(RoundedCornerShape(15.dp))
                                        .padding(3.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = BlueDark,
                                        contentColor = White
                                    )
                                ) {
                                    Text(text = "Share",
                                        style = TextStyle(
                                            fontSize = 9.sp,
                                            fontFamily = FontFamily.SansSerif,
                                        )
                                    )

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SummaryScreenPreview() {
    AlFalakMainTheme() {
        SummaryScreen(navHostController = rememberNavController())
    }
}