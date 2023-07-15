package com.example.al_falakmain.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.example.al_falakmain.components.ButtonSimple
import com.example.al_falakmain.components.CircleImageView
import com.example.al_falakmain.components.EditText
import com.example.al_falakmain.components.EditTextSimple
import com.example.al_falakmain.components.SimpleTextview
import com.example.al_falakmain.components.getDatePickerDialog
import com.example.al_falakmain.data.models.recoveryItem
import com.example.al_falakmain.routes.Routes
import com.example.al_falakmain.ui.theme.AlFalakMainTheme
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.White
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

@Composable
fun RecoverScreen(navHostController: NavHostController) {
    Scaffold() {
        Box(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .background(White)
                .padding(bottom = 20.dp)
        ) {
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
                    .padding(top = 180.dp, start = 16.dp, end = 16.dp)
                    .align(Alignment.TopCenter),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Recovery Report",
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

                DatePickDialog()
                RecoverList()
            }

        }
    }
}

@Composable
fun DatePickDialog(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var mDate by remember { mutableStateOf("") }
    var toDate by remember { mutableStateOf("") }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        EditTextSimple(modifier = Modifier
            .weight(0.3f)
            .clickable {
                val dialog = getDatePickerDialog(
                    { selectedDate ->
                        mDate = selectedDate
                        Toast
                            .makeText(
                                context,
                                "$selectedDate",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    },
                    context
                )
                dialog.show()
            }, value = mDate, onValueChanged = { mDate = it }, placeholder = "From",
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calender), tint = BlueDark,
                    contentDescription = "calender icon", modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(18.dp)
                )
            }, enabled = false, fontSize = 12.sp
        )
        Spacer(modifier = Modifier.width(10.dp))
        EditTextSimple(modifier = Modifier
            .weight(0.3f)
            .clickable {
                val dialog = getDatePickerDialog(
                    { selectedDate ->
                        toDate = selectedDate
                        Toast
                            .makeText(
                                context,
                                "$selectedDate",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    },
                    context
                )
                dialog.show()
            }, value = toDate, onValueChanged = { toDate = it }, placeholder = "To",
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calender), tint = BlueDark,
                    contentDescription = "calender icon", modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(18.dp)
                )
            }, enabled = false, fontSize = 12.sp
        )

        ButtonSimple(modifier = Modifier
            .padding(0.dp)
            .weight(0.3f), text = "Show",
            onClick = {

            })



    }
}

@Composable
fun RecoverList(modifier: Modifier = Modifier) {
    RecoverItem(recoveryItem = listOf(
        recoveryItem(
            "12021", "Mirza Ali",
            "", 100000.0, 5000.0, "01-01-2023", "Hello world"
        ),
        recoveryItem(
            "12021", "Mirza Ali",
            "", 100000.0, 5000.0, "01-01-2023", "Hello world"
        ),
        recoveryItem(
            "12021", "Mirza Ali",
            "", 100000.0, 5000.0, "01-01-2023", "Hello world"
        ),
        recoveryItem(
            "12021", "Mirza Ali",
            "", 100000.0, 5000.0, "01-01-2023", "Hello world"
        ),
        recoveryItem(
            "12021", "Mirza Ali",
            "", 100000.0, 5000.0, "01-01-2023", "Hello world"
        ),
        recoveryItem(
            "12021", "Mirza Ali",
            "", 100000.0, 5000.0, "01-01-2023", "Hello world"
        ),
        recoveryItem(
            "12021", "Mirza Ali",
            "", 100000.0, 5000.0, "01-01-2023", "Hello world"
        ),
        recoveryItem(
            "12021", "Mirza Ali",
            "", 100000.0, 5000.0, "01-01-2023", "Hello world"
        ),
        recoveryItem(
            "12021", "Mirza Ali",
            "", 100000.0, 5000.0, "01-01-2023", "Hello world"
        ), recoveryItem(
            "12021", "Mirza Ali",
            "", 100000.0, 5000.0, "01-01-2023", "Hello world"
        ),

    ), onItemClick = {
        Log.e("TAG", "RecoverList: $it")
    }, modifier = modifier.fillMaxWidth())
}

@Composable
fun RecoverItem(
    modifier: Modifier = Modifier,
    recoveryItem: List<recoveryItem>,
    onItemClick: (item: String) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {

        items(recoveryItem.size) {
            val item = recoveryItem[it]
            Card(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .padding(5.dp),
                elevation =CardDefaults.cardElevation(
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
                            text = "Account Number: ${item.account}", fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(vertical = 5.dp)
                        )
                        Row(horizontalArrangement = Arrangement.SpaceBetween) {
                            val fixWidthModifier=Modifier.weight(0.4f)
                            SimpleTextview(
                                text = item.name, fontWeight = FontWeight.SemiBold, modifier = fixWidthModifier.padding(vertical = 5.dp)
                            )
                            SimpleTextview(
                                text = "${item.balance.toString()} DB", fontWeight = FontWeight.SemiBold, modifier = fixWidthModifier.padding(vertical = 5.dp)
                            )
                        }
                        SimpleTextview(
                            text = item.date, fontWeight = FontWeight.SemiBold
                        )
                        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                            val fixWidthModifier=Modifier.weight(0.4f)
                            SimpleTextview(
                                text = "Total Balance", fontWeight = FontWeight.SemiBold, modifier = fixWidthModifier.padding(vertical = 5.dp)
                            )
                            SimpleTextview(
                                text = "${item.amount} DB", fontWeight = FontWeight.SemiBold, modifier = fixWidthModifier.padding(vertical = 5.dp)
                            )
                        }
                        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                            val fixWidthModifier=Modifier.weight(0.4f)
                            ButtonSimple(text = "Call/SMS", onClick = { /*TODO*/ }, modifier = Modifier.weight(0.3f), textSize = 12.sp, height = 40.dp)
                            ButtonSimple(text = "Change Alert Date", onClick = { /*TODO*/ }, modifier = fixWidthModifier, textSize = 12.sp, height = 40.dp)
//                            ButtonSimple(text = "Submit"
//                                , modifier = Modifier.padding(start = 50.dp, end = 50.dp)
//                                , onClick = {
//                                }
//                            )
                        }
                    }
                }
            }

        }
    }


}


@Preview
@Composable
fun RecoveryScreenPreview() {
    AlFalakMainTheme {
        RecoverScreen(navHostController = rememberNavController())
    }
}