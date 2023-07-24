package com.example.al_falakmain.ui.screens

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.example.al_falakmain.ui.components.ButtonSimple
import com.example.al_falakmain.ui.components.DropdownSpinner
import com.example.al_falakmain.ui.components.EditTextSimple
import com.example.al_falakmain.ui.components.SimpleTextview
import com.example.al_falakmain.ui.components.getDatePickerDialog
import com.example.al_falakmain.data.models.statementItem
import com.example.al_falakmain.ui.theme.AlFalakMainTheme
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.BlueLight
import com.example.al_falakmain.ui.theme.White

@Composable
fun StatementScreen(navHostController: NavHostController) {
    Scaffold() {
        Box(
            modifier = Modifier
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

                val optionsCustomer = listOf("Mirza Ali", "Shafqat Bhatti", "Asif Bhatti")
                val selectedCustomer = remember { mutableStateOf("") }
                DropdownSpinner(
                    options = optionsCustomer,
                    selectedOption = selectedCustomer.value,
                    onOptionSelected = { option ->
                        selectedCustomer.value = option
                    },
                    title = "Select user account",
                    modifier = Modifier.padding(top = 16.dp, bottom = 5.dp)
                )
                DatePickStatement()
                StatementHeaders()
            }
        }
    }
}

@Composable
fun DatePickStatement(modifier: Modifier = Modifier) {
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
                                context, "$selectedDate", Toast.LENGTH_SHORT
                            )
                            .show()
                    }, context
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
fun StatementHeaders(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(40.dp)
    ) {

        SimpleTextview(
            text = "Date",
            textColor = BlueLight,
            modifier = Modifier
                .weight(0.2f)
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
        )
        SimpleTextview(
            text = "ID",
            textColor = BlueLight,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(0.18f)
                .align(Alignment.CenterVertically)
        )
        SimpleTextview(
            text = "Debit",
            textColor = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(0.18f)
                .align(Alignment.CenterVertically)
        )
        SimpleTextview(
            text = "Credit",
            textColor = Color.Green,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(0.18f)
                .align(Alignment.CenterVertically)
        )
        SimpleTextview(
            text = "Balance",
            textColor = BlueLight,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(0.18f)
                .align(Alignment.CenterVertically)
        )
        Spacer(
            modifier = Modifier
                .weight(0.08f)
                .size(18.dp)
        )
    }
    StatementListItem(statementItem = listOf(
        statementItem(
            "01-01-2023",
            "10000",
            100000.0,
            400000.0,
            10000000.0
        ),
        statementItem(
            "01-01-2023",
            "10000",
            100000.0,
            400000.0,
            10000000.0
        ),
        statementItem(
            "01-01-2023",
            "10000",
            100000.0,
            400000.0,
            10000000.0
        ),
        statementItem(
            "01-01-2023",
            "10000",
            100000.0,
            400000.0,
            10000000.0
        ),
        statementItem(
            "01-01-2023",
            "10000",
            100000.0,
            400000.0,
            10000000.0
        ),
        statementItem(
            "01-01-2023",
            "10000",
            100000.0,
            400000.0,
            10000000.0
        ), statementItem(
            "01-01-2023",
            "10000",
            100000.0,
            400000.0,
            10000000.0
        ),
        statementItem(
            "01-01-2023",
            "10000",
            100000.0,
            400000.0,
            10000000.0
        ),
        statementItem(
            "01-01-2023",
            "10000",
            100000.0,
            400000.0,
            10000000.0
        ),
        statementItem(
            "01-01-2023",
            "10000",
            100000.0,
            400000.0,
            10000000.0
        ),

    ), onItemSelected ={
        Log.e("TAG", "StatementHeaders: $it", )
    })
}

@Composable
fun StatementListItem(
    modifier: Modifier = Modifier,
    statementItem: List<statementItem>,
    onItemSelected: (selectedItem: String) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(statementItem.size) {
            val item = statementItem[it]
            Card(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 2.dp)
                    .fillMaxWidth().background(White)
                    ,
                colors = CardDefaults.cardColors(
                    containerColor = White,
                    contentColor = White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                ),



            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically, modifier = modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth()
                        .height(40.dp)
                        .clickable { onItemSelected(item.accountId) }
                ) {

                    SimpleTextview(
                        text = item.date,
                        textColor = BlueLight,
                        modifier = Modifier
                            .weight(0.2f)
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center,
                    )
                    SimpleTextview(
                        text = item.accountId,
                        textColor = BlueLight,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(0.18f)
                            .align(Alignment.CenterVertically)
                    )
                    SimpleTextview(
                        text = item.debit.toString(),
                        textColor = Color.Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(0.18f)
                            .align(Alignment.CenterVertically)
                    )
                    SimpleTextview(
                        text = item.credit.toString(),
                        textColor = Color.Green,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(0.18f)
                            .align(Alignment.CenterVertically)
                    )
                    SimpleTextview(
                        text = item.balance.toString(),
                        textColor = BlueLight,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(0.18f)
                            .align(Alignment.CenterVertically)
                    )
                    Icon(
                        painterResource(id = R.drawable.ic_forward),
                        contentDescription = "",
                        modifier = Modifier
                            .weight(0.08f)
                            .size(18.dp)
                    )
                }


            }
        }
    }
}

@Preview
@Composable
fun StatementScreenPreview() {
    AlFalakMainTheme() {
        StatementScreen(navHostController = rememberNavController())
    }
}


