package com.example.al_falakmain.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.al_falakmain.R
import com.example.al_falakmain.ui.components.ButtonSimple
import com.example.al_falakmain.ui.components.SimpleTextview
import com.example.al_falakmain.ui.components.TextViewBorder
import com.example.al_falakmain.data.models.roleItem
import com.example.al_falakmain.ui.routes.Routes
import com.example.al_falakmain.ui.theme.AlFalakMainTheme
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.White

@Composable
fun RoleManagementScreen(navHostController: NavHostController) {
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
                        .padding(top = 180.dp)
                        .align(Alignment.TopCenter),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Create New Role",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 16.sp,
                            color = White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp)
                            .clip(
                                RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                            )
                            .background(BlueDark)
                            .padding(10.dp)
                            .clickable {
                                navHostController.navigate(Routes.CreateRolesScreen.route)
                            },


                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    RoleFromList(
                        columns = 1, onItemSelected = {}, roleItems = listOf(
                            roleItem("Manager"),
                            roleItem("Manager"),
                            roleItem("Manager"),
                            roleItem("Manager"),
                            roleItem("Manager"),
                            roleItem("Manager"),
                            roleItem("Admin"),
                        )
                    )

                }
            }
        }
    }
}

@Composable
fun RoleFromList(
    modifier: Modifier = Modifier, columns: Int,
    onItemSelected: (selectedItem: String) -> Unit, roleItems: List<roleItem>
) {

    val selectedItem = remember {
        mutableStateOf("")
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = modifier.padding(vertical = 16.dp)
    ) {
        items(roleItems.count()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(5.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(5.dp))
                    .clickable {
                        selectedItem.value = roleItems[it].roleName
                        onItemSelected(selectedItem.value)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                SimpleTextview(
                    text = "Role Name",
                    modifier = Modifier.weight(0.5f),
                    textAlign = TextAlign.Center
                )
                ButtonSimple(
                    text = "Edit",
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(0.25f)
                )
                ButtonSimple(
                    text = "Delete",
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(0.25f)
                )

            }
        }
    }
}

@Preview
@Composable
fun RoleManagementScreenPreview() {
    AlFalakMainTheme() {
        RoleManagementScreen(navHostController = rememberNavController())
    }
}
