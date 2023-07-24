package com.example.al_falakmain.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.al_falakmain.R
import com.example.al_falakmain.ui.components.CircleImageView
import com.example.al_falakmain.ui.components.CustomTopAppBar
import com.example.al_falakmain.ui.theme.White
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.al_falakmain.ui.components.ButtonSimple
import com.example.al_falakmain.ui.components.DropdownSpinner
import com.example.al_falakmain.ui.components.EditText
import com.example.al_falakmain.ui.routes.Routes
import com.example.al_falakmain.ui.theme.AlFalakMainTheme
import com.example.al_falakmain.ui.theme.Black
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.BlueOutlineColor

@Composable
fun LoanRequestScreen(navHostController: NavHostController) {
    AlFalakMainTheme() {
        androidx.compose.material.Scaffold(

            content = {
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
                        painter = painterResource(id = com.example.al_falakmain.R.drawable.splash_logo),
                        contentDescription = "Logo", modifier = Modifier
                            .padding(top = 100.dp, start = 50.dp, end = 50.dp)
                            .height(50.dp)
                            .align(TopCenter)
                    )
                    val scrollState= rememberScrollState()
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 170.dp, start = 16.dp, end = 16.dp)
                            .align(Alignment.TopCenter)
                            .verticalScroll(scrollState),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = CenterHorizontally
                    ) {
                        val optionsCustomer = listOf("Mirza Ali", "Shafqat Bhatti", "Asif Bhatti")
                        val selectedCustomer = remember { mutableStateOf("") }

                        val qty = remember {
                            mutableStateOf("")
                        }
                        val price = remember {
                            mutableStateOf("")
                        }
                        val description = remember {
                            mutableStateOf("")
                        }
                        DropdownSpinner(
                            options = optionsCustomer,
                            selectedOption = selectedCustomer.value,
                            onOptionSelected = { option ->
                                selectedCustomer.value = option
                            },
                            title = "Select customer account",
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        CustomerBalance( modifier = Modifier.padding(bottom = 5.dp))


                        val optionsOilCat = listOf("Oil", "Expense", "Lube")
                        val selectedOilCat = remember { mutableStateOf("") }


                        DropdownSpinner(
                            options = optionsOilCat,
                            selectedOption = selectedOilCat.value,
                            onOptionSelected = { option ->
                                selectedOilCat.value = option
                            },
                            title = "Select oil category",
                            modifier = Modifier.padding(bottom = 10.dp)
                        )

                        val optionsOilProduct = listOf("Petrol", "Diesel", "Lube")
                        val selectedOilProduct = remember { mutableStateOf("") }
                        DropdownSpinner(
                            options = optionsOilProduct,
                            selectedOption = selectedOilProduct.value,
                            onOptionSelected = { option ->
                                selectedOilProduct.value = option
                            },
                            title = "Select oil product",
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        EditText(
                            modifier = Modifier.padding(bottom = 10.dp),
                            value = qty.value,
                            onValueChanged = {v-> qty.value = v },
                            placeholder = "Quantity",
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                        EditText(
                            modifier = Modifier.padding(bottom = 10.dp),
                            value = qty.value,
                            onValueChanged = {v-> qty.value = v },
                            placeholder = "Price",
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                        )
                        EditText(
                            modifier = Modifier.padding(bottom = 10.dp),
                            value = qty.value,
                            onValueChanged = {v-> qty.value = v },
                            placeholder = "Price",
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )
                        CircleImageView(
                            imageId = R.drawable.ic_person,
                            modifier = Modifier
                                .padding(top = 10.dp)
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
            })
    }

}



@Composable
fun CustomerBalance(
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()
    ) {
        CustomerBalanceColumn(title = "Allow limit", value = "1000.00", onClick = {})
        CustomerBalanceColumn(title = "Used limit", value = "1000.00", onClick = {})
        CustomerBalanceColumn(title = "Rem limit", value = "1000.00", onClick = {})

    }
}

@Composable
fun CustomerBalanceColumn(onClick: () -> Unit,modifier: Modifier=Modifier,title: String,value:String) {
    OutlinedButton(onClick = onClick,modifier = Modifier
        .width(120.dp)
        .height(55.dp)
        .clip(
            RoundedCornerShape(10.dp)
        )

        .padding(4.dp),
    border = BorderStroke(1.dp, BlueOutlineColor)
    ) {
        Column(modifier=modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Text(
                text = value,
                style = TextStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }
    }

}

@Preview
@Composable
fun LoanRequestPreview() {
    LoanRequestScreen(navHostController = rememberNavController())
}