package com.example.al_falakmain.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.al_falakmain.ui.components.DropdownSpinner
import com.example.al_falakmain.ui.components.SimpleTextview
import com.example.al_falakmain.data.models.lubeReportItem
import com.example.al_falakmain.data.models.recoveryItem
import com.example.al_falakmain.ui.routes.Routes
import com.example.al_falakmain.ui.theme.AlFalakMainTheme
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.White

@Composable
fun LubeReportScreen(navHostController: NavHostController) {
    AlFalakMainTheme() {
        Scaffold() {
            Box(
                modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues = it)
                    .background(White)
                    .padding(bottom = 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 16.dp, end = 16.dp)
                        .align(Alignment.TopCenter),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Lube Report",
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
                    val optionYears = listOf("2018", "2019", "2020", "2021", "2022", "2023", "2024")
                    val selectedYear = remember { mutableStateOf("") }
                    DropdownSpinner(
                        options = optionYears,
                        selectedOption = selectedYear.value,
                        onOptionSelected = { option ->
                            selectedYear.value = option
                        },
                        title = "Select Year",
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    val optionMonth = listOf(
                        "January",
                        "February",
                        "March",
                        "April",
                        "May",
                        "June",
                        "July",
                        "August",
                        "September",
                        "October",
                        "November",
                        "December"
                    )
                    val selectedMonth = remember { mutableStateOf("") }
                    DropdownSpinner(
                        options = optionMonth,
                        selectedOption = selectedMonth.value,
                        onOptionSelected = { option ->
                            selectedMonth.value = option
                        },
                        title = "Select Month",
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    val optionAccount = listOf("Abdullah", "Isa", "Ali", "Samar")
                    val selectedAccount = remember { mutableStateOf("") }
                    DropdownSpinner(
                        options = optionAccount,
                        selectedOption = selectedAccount.value,
                        onOptionSelected = { option ->
                            selectedAccount.value = option
                        },
                        title = "Select Account",
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    var isVisible by remember {
                        mutableStateOf(false)
                    }
                    ButtonSimple(text = "Search",
                        modifier = Modifier.padding(start = 50.dp, end = 50.dp),
                        onClick = {
                            isVisible =true
                        }
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        SimpleTextview(
                            text = "Loan Limit is 10000", textColor = BlueDark,
                            modifier = Modifier.weight(1f), textAlign = TextAlign.Center
                        )
                        SimpleTextview(
                            text = "Used Limit is 10000", textColor = BlueDark,
                            modifier = Modifier.weight(1f), textAlign = TextAlign.Center
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp)
                            .height(1.dp)
                            .background(Color.LightGray)
                    )
                    if (isVisible){
                        LubeReportList(lubeReportItem = listOf(
                            lubeReportItem(
                                "DEO 3000 (10 ltr) diesel engine No 50 ", "Mirza Ali",
                                "", 100000.0, 1.0, "01-01-2023",
                            ),
                            lubeReportItem(
                                "12021", "Mirza Ali",
                                "", 100000.0, 1.0, "01-01-2023",
                            ),
                            lubeReportItem(
                                "12021", "Mirza Ali",
                                "", 100000.0, 2.0, "01-01-2023",
                            ),
                            lubeReportItem(
                                "12021", "Mirza Ali",
                                "", 100000.0, 3.0, "01-01-2023",
                            ),
                            lubeReportItem(
                                "12021", "Mirza Ali",
                                "", 100000.0, 4.0, "01-01-2023",
                            ),
                            lubeReportItem(
                                "12021", "Mirza Ali",
                                "", 100000.0, 5.0, "01-01-2023",
                            ),
                            lubeReportItem(
                                "12021", "Mirza Ali",
                                "", 100000.0, 6.0, "01-01-2023",
                            ),
                            lubeReportItem(
                                "12021", "Mirza Ali",
                                "", 100000.0, 7.0, "01-01-2023",
                            ),
                            lubeReportItem(
                                "12021", "Mirza Ali",
                                "", 100000.0, 8.0, "01-01-2023",
                            ), lubeReportItem(
                                "12021", "Mirza Ali",
                                "", 100000.0, 9.0, "01-01-2023",
                            ),

                            ), onItemClick = {

                        })
                    }

                }
            }
        }
    }
}

@Composable
fun LubeReportList(
    modifier: Modifier = Modifier,
    lubeReportItem: List<lubeReportItem>,
    onItemClick: (item: String) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {

        items(lubeReportItem.size) {
            val item = lubeReportItem[it]
            Card(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .padding(5.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                ),
                colors = CardDefaults.cardColors(
                    containerColor = White,

                    )

            ) {
                Row(modifier = Modifier
                    .height(160.dp)
                    .clickable {
                        onItemClick(item.name)
                    },
                    verticalAlignment = Alignment.CenterVertically) {
                    val firstColModifier = Modifier.weight(0.2f)
                    val secondColumnModifier = Modifier.weight(0.8f)
                    Column(
                        modifier = firstColModifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircleImageView(imageId = R.drawable.ic_person, modifier = Modifier.size(40.dp))
                    }
                    Column(modifier = secondColumnModifier) {
                        SimpleTextview(
                            text = item.name, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(vertical = 5.dp)
                        )
                        SimpleTextview(
                            text = item.product, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(vertical = 5.dp)
                        )
                        SimpleTextview(
                            text = "Quantity purchased: ${item.quantity} ", fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(vertical = 5.dp)
                        )
                        SimpleTextview(
                            text = "Price: ${item.price}", fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(vertical = 5.dp)
                        )

                    }
                }
            }

        }
    }

}

@Preview
@Composable
fun LubeReportScreenPreview() {
    AlFalakMainTheme() {
        LubeReportScreen(navHostController = rememberNavController())
    }
}