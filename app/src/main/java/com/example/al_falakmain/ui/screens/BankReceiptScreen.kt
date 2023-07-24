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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.al_falakmain.R
import com.example.al_falakmain.ui.components.ButtonSimple
import com.example.al_falakmain.ui.components.DropdownSpinner
import com.example.al_falakmain.ui.components.EditText
import com.example.al_falakmain.ui.components.EditTextRaw
import com.example.al_falakmain.ui.components.SimpleTextview
import com.example.al_falakmain.ui.components.TextViewBorder
import com.example.al_falakmain.ui.routes.Routes
import com.example.al_falakmain.ui.theme.AlFalakMainTheme
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.White

@Composable
fun BankReceiptScreen(navHostController: NavHostController) {
    AlFalakMainTheme() {
        Scaffold() {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(White)
                    .padding(bottom = 20.dp)
            )
            {
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

                    SimpleTextview(
                        text = "Bank Receipt", textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold, textColor = BlueDark
                        , fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.End)
                    ) {
                        SimpleTextview(
                            text = "Voucher No",
                            modifier = Modifier.width(100.dp),
                            textColor = BlueDark,
                            textAlign = TextAlign.Center,
                        )
                        TextViewBorder(text = "10442", textAlign = TextAlign.Center, modifier = Modifier.width(60.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Cash in hand 100000/Rs CR",
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
                    val amount = remember {
                        mutableStateOf("")
                    }
                    val details = remember {
                        mutableStateOf("")
                    }
                    val optionsBanks = listOf("MCB Bank", "Allied Bank", "Meezan Bank")
                    val selectedBank = remember { mutableStateOf("") }
                    DropdownSpinner(
                        options = optionsBanks,
                        selectedOption = selectedBank.value,
                        onOptionSelected = { option ->
                            selectedBank.value = option
                        },
                        title = "Select Bank",
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    val optionsCustomer = listOf("Mirza Ali", "Shafqat Bhatti", "Asif Bhatti")
                    val selectedCustomer = remember { mutableStateOf("") }
                    DropdownSpinner(
                        options = optionsCustomer,
                        selectedOption = selectedCustomer.value,
                        onOptionSelected = { option ->
                            selectedCustomer.value = option
                        },
                        title = "Select user account",
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    SimpleTextview(text = "Balance : 10000 CR", textAlign = TextAlign.End)
                    Spacer(modifier = Modifier.height(10.dp))
                    EditText(
                        modifier = Modifier.padding(bottom = 10.dp),
                        value = amount.value.toString(),
                        onValueChanged = {v-> amount.value = v },
                        placeholder = "Amount",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    EditTextRaw(
                        modifier = Modifier.padding(bottom = 10.dp),
                        value = amount.value.toString(),
                        onValueChanged = {v-> amount.value = v },
                        placeholder = "Details",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    Spacer(modifier = Modifier.height(60.dp))
                    ButtonSimple(text = "Submit"
                        , modifier = Modifier.padding(start = 50.dp, end = 50.dp)
                        , onClick = {
                            navHostController.navigate(Routes.SummaryScreen.route)
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BankReceiptScreenPreview() {
    AlFalakMainTheme {
        BankReceiptScreen(navHostController = rememberNavController())
    }

}