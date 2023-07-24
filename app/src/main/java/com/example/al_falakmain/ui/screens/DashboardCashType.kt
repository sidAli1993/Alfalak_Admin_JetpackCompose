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
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.al_falakmain.R
import com.example.al_falakmain.common.navigateToScreens
import com.example.al_falakmain.ui.components.CircleImageView
import com.example.al_falakmain.data.models.dashboardItem
import com.example.al_falakmain.ui.theme.AlFalakMainTheme
import com.example.al_falakmain.ui.theme.White

@Composable
fun DashboardComposeType(navHostController: NavHostController) {
    Scaffold() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .background(White)
                .padding(bottom = 20.dp)
        ) {

            Image(
                painter = painterResource(id = com.example.al_falakmain.R.drawable.splash_logo),
                contentDescription = "Logo", modifier = Modifier
                    .padding(top = 50.dp, start = 50.dp, end = 50.dp)
                    .height(50.dp)
                    .align(Alignment.TopCenter)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 130.dp, start = 16.dp, end = 16.dp)
                    .align(Alignment.TopCenter),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                DetailBoxesCashType(navHostController)
            }


        }
    }
}
@Composable
fun DetailBoxesCashType(navHostController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        DetailBoxComponent(
            boxItems = listOf(
                dashboardItem("Cash Payment", R.drawable.ic_cashpay),
                dashboardItem("Cash Receipt", R.drawable.ic_cashrecv),
                dashboardItem("Bank Payment", R.drawable.ic_bankrecv),
                dashboardItem("Bank Receipt", R.drawable.ic_bankrecv),
            ), modifier = Modifier
                .fillMaxWidth(), navHostController = navHostController,
            onBoxItemClick = {selectedItem->
                navigateToScreens(navHostController,selectedItem)
            },
            gridCells = 2
        )
    }

}

@Preview
@Composable
fun DashboardComposeTypePreview() {
    AlFalakMainTheme() {
        DashboardComposeType(navHostController = rememberNavController())
    }
}