package com.example.al_falakmain.screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.al_falakmain.components.ButtonSimple
import com.example.al_falakmain.components.SimpleTextview
import com.example.al_falakmain.components.TextViewBorder
import com.example.al_falakmain.data.models.roleItem
import com.example.al_falakmain.routes.Routes
import com.example.al_falakmain.ui.theme.AlFalakMainTheme
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.LightGray
import com.example.al_falakmain.ui.theme.White

@Composable
fun CreateRoleScreen(navHostController: NavHostController) {
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
                val mutableListRoles = remember {
                    mutableStateListOf(
                        roleItem("Manager"),
                        roleItem("Supervisor"),
                        roleItem("Admin"),
                        roleItem("ABC"),
                        roleItem("Def"),
                    )
                }

                val mutableSelectedListRoles = remember {
                    mutableStateListOf<roleItem>()
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    TextViewBorder(
                        text = "Tap to select the role", modifier = Modifier.background(
                            BlueDark
                        ), textColor = White, textAlign = TextAlign.Center, fontSize = 14.sp
                    )
                    ShowAllRoles(
                        roleItem = mutableListRoles,
                        selectedRole = {
                            mutableSelectedListRoles.add(roleItem(it))
                            mutableListRoles.remove(roleItem(it))
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 16.dp)
                    )
                    TextViewBorder(
                        text = "Tap to remove the selected role", modifier = Modifier.background(
                            BlueDark
                        ), textColor = White, textAlign = TextAlign.Center, fontSize = 14.sp
                    )
                    ShowAllRoles(
                        roleItem = mutableSelectedListRoles,
                        selectedRole = {
                            mutableListRoles.add(roleItem(it))
                            mutableSelectedListRoles.remove(roleItem(it))
                        },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.height(100.dp))
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

@Composable
fun ShowAllRoles(
    modifier: Modifier = Modifier,
    roleItem: List<roleItem>,
    selectedRole: (String) -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(roleItem.count()) {
                Card(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth()
                        .clickable {
                            selectedRole(roleItem[it].roleName)
                        },
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp,
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = White,

                        )

                ) {
                    SimpleTextview(
                        text = roleItem[it].roleName,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                    )

                }

            }
        }
    }

}

@Composable
fun ShowSelectedRoles(
    modifier: Modifier = Modifier,
    roleItem: List<roleItem>,
    selectedRole: (String) -> Unit,
) {
    val selectedItem = remember {
        mutableStateOf("")
    }
    LazyColumn(modifier = modifier) {
        items(roleItem.count()) {
            SimpleTextview(text = roleItem[it].roleName, modifier = Modifier.clickable {
                selectedItem.value = roleItem[it].roleName
                selectedRole(selectedItem.value)
            })
        }
    }
}

@Preview
@Composable
fun CreateRoleScreenPreview() {
    AlFalakMainTheme() {
        CreateRoleScreen(navHostController = rememberNavController())
    }
}