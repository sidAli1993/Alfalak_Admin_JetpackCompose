package com.example.al_falakmain.screens

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.util.Log
import android.widget.ScrollView
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults.outlinedButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.al_falakmain.common.navigateToScreens
import com.example.al_falakmain.components.BottomBar
import com.example.al_falakmain.components.CircleImageView
import com.example.al_falakmain.components.CustomTopAppBar
import com.example.al_falakmain.data.models.dashboardItem
import com.example.al_falakmain.routes.Routes
import com.example.al_falakmain.ui.theme.AlFalakMainTheme
import com.example.al_falakmain.ui.theme.Black
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.BlueLight
import com.example.al_falakmain.ui.theme.BlueOutlineColor
import com.example.al_falakmain.ui.theme.ItemBackground
import com.example.al_falakmain.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navHostController: NavHostController) {

    Scaffold(
//        topBar = {
//            CustomTopAppBar(
//                navController = navHostController,
//                title = "Dashboard",
//                showBackIcon = false,
//                showRightIcon = true
//            )
//        },
        bottomBar = {
            BottomAppBar(
                cutoutShape = CircleShape,
                backgroundColor = BlueDark,
                content = {
                    BottomNavigation(
                        backgroundColor = BlueDark,
                        modifier = Modifier.background(BlueDark)
                    ) {

                        BottomNavigationItem(
                            selected = true,
                            onClick = { /* Handle item click */ },
                            icon = {
                                Image(
                                    painter = painterResource(id = com.example.al_falakmain.R.drawable.baseline_toggle_off_24),
                                    contentDescription = "",modifier = Modifier.size(24.dp)
                                )

                            },
                            label = { androidx.compose.material.Text("On-Off", style = TextStyle(
                                fontSize = 10.sp, color = White, fontFamily = FontFamily.SansSerif
                            )
                            ) }
                        )
                        BottomNavigationItem(
                            selected = false,
                            onClick = { /* Handle item click */ },
                            icon = {
                                Image(
                                    painter = painterResource(id = com.example.al_falakmain.R.drawable.ic_time_change),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(24.dp)
                                        .width(20.dp)
                                )

                            },
                            label = { androidx.compose.material.Text("Time", style = TextStyle(
                                fontSize = 10.sp, color = White, fontFamily = FontFamily.SansSerif
                            )) }
                        )
                        BottomNavigationItem(
                            selected = false,
                            onClick = { /* Handle item click */ },
                            icon = {
                                Image(
                                    painter = painterResource(id = com.example.al_falakmain.R.drawable.icdummy),
                                    contentDescription = "",
                                    modifier = Modifier.size(24.dp)
                                )

                            },
                        )
                        BottomNavigationItem(
                            selected = false,
                            onClick = { /* Handle item click */ },
                            icon = {
                                Image(
                                    painter = painterResource(id = com.example.al_falakmain.R.drawable.ic_help_line),
                                    contentDescription = "",
                                    modifier = Modifier.size(24.dp)
                                )

                            },
                            label = { androidx.compose.material.Text("HelpLine", style = TextStyle(
                                fontSize = 10.sp, color = White, fontFamily = FontFamily.SansSerif
                            )) }
                        )
                        BottomNavigationItem(
                            selected = false,
                            onClick = { /* Handle item click */ },
                            icon = {
                                Image(
                                    painter = painterResource(id = com.example.al_falakmain.R.drawable.ic_whatsapp),
                                    contentDescription = "",
                                    modifier = Modifier.size(24.dp)
                                )

                            },
                            label = { androidx.compose.material.Text("WhatsApp", style = TextStyle(
                                fontSize = 10.sp, color = White, fontFamily = FontFamily.SansSerif
                            )) }
                        )

                        // Add more bottom bar items as needed
                    }
                }
            )
        },
        floatingActionButton = {
            androidx.compose.material.FloatingActionButton(
                onClick = { /* Handle FAB click */ },
                content = {
                    Image(
                        painter = painterResource(id = com.example.al_falakmain.R.drawable.baseline_qr_code_2_24),
                        contentDescription = "Qr",
                        modifier = Modifier.size(24.dp)
                    )
                },
                backgroundColor = Color.White,
                modifier = Modifier.background(White)
            )
        },
        floatingActionButtonPosition = androidx.compose.material.FabPosition.Center,
        isFloatingActionButtonDocked = true,

        ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .background(White)
                .padding(bottom = 20.dp)
        ) {
            Image(
                painter = painterResource(id = com.example.al_falakmain.R.drawable.newback),
                contentDescription = "back Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            )
            Spacer(modifier = Modifier.height(10.dp))
            CircleImageView(
                imageId = com.example.al_falakmain.R.drawable.ic_person,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 60.dp)
            )
            Image(
                painter = painterResource(id = com.example.al_falakmain.R.drawable.ic_power),
                contentDescription = "back Image",
                modifier = Modifier
                    .padding(16.dp)
                    .size(30.dp)
                    .align(Alignment.TopEnd)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 170.dp, start = 16.dp, end = 16.dp)
                    .align(Alignment.TopCenter),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                PersonData(
                    name = "Mirza Ali", phone = "03224379402", balance = 1500.00,
                )
                Spacer(modifier = Modifier.height(10.dp))
                ProductsQuantity()
                DetailBoxes(navHostController)
                Spacer(modifier = Modifier.height(10.dp))

            }
//            Banner(modifier = Modifier.align(BottomCenter))

        }

    }
}

@Composable
fun PersonData(
    name: String,
    phone: String,
    balance: Double,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Balance: ${balance.toString()} DR", style = TextStyle(
                color = Black,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                fontFamily = FontFamily.SansSerif,
            )
        )
    }
}

@Composable
fun ProductsQuantity(modifier: Modifier = Modifier, minWidth: Dp = 120.dp, minHeight: Dp = 45.dp) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ButtonColumn(
            text = "Diesel", value = "10000",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(minHeight)
        )


        ButtonColumn(
            text = "Nozzle", value = "1000",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(minHeight)
        )
        ButtonColumn(
            text = "Petrol", value = "10000",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(minHeight)
        )
    }
}

@Composable
fun ButtonColumn(modifier: Modifier = Modifier, text: String, value: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(end = 10.dp)
            .border(width = 1.dp, color = BlueOutlineColor, shape = RoundedCornerShape(5.dp))
    ) {
        Text(
            text = text, style = TextStyle(
                color = Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
            )
        )
        Text(
            text = value, style = TextStyle(
                color = Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
            )
        )
    }
}

@Composable
fun DetailBoxes(navHostController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        DetailBoxComponent(
            boxItems = listOf(
                dashboardItem("Cash type", com.example.al_falakmain.R.drawable.ctype),
                dashboardItem("Loan request", com.example.al_falakmain.R.drawable.lreq),
                dashboardItem("Lube report", com.example.al_falakmain.R.drawable.luber),
                dashboardItem("Ledger", com.example.al_falakmain.R.drawable.ledge),
                dashboardItem("Recovery", com.example.al_falakmain.R.drawable.recov),
                dashboardItem(
                    "Customer request",
                    com.example.al_falakmain.R.drawable.custreq
                ),
                dashboardItem("Search V", com.example.al_falakmain.R.drawable.sv),
                dashboardItem("Roles", com.example.al_falakmain.R.drawable.role),
                dashboardItem(
                    "Customer accountdsfsdf",
                    com.example.al_falakmain.R.drawable.custacc
                ),
            ), modifier = Modifier
                .fillMaxWidth(), navHostController = navHostController,
            onBoxItemClick = {selectedItem->
                navigateToScreens(navHostController,selectedItem)
            }
        )
    }

}

@Composable
fun DetailBoxComponent(modifier: Modifier = Modifier, boxItems: List<dashboardItem>,navHostController: NavHostController,
                       onBoxItemClick: (selectedItem:String) -> Unit,gridCells:Int=3) {
    val letterSpacing = 0.5.sp
    val selectedItem = remember { mutableStateOf("") }

    LazyVerticalGrid(
        columns = GridCells.Fixed(gridCells), modifier = modifier
//            .padding(bottom = 115.dp)
    ) {
        items(boxItems.size) {
            Box(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
                    .fillMaxSize()
                    .clickable {
                        selectedItem.value = boxItems[it].boxName
                        onBoxItemClick(selectedItem.value)
                        Log.e("TAG", "DetailBoxComponent: ${boxItems[it].boxName}",)
                    }

                ,
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        ,
                    painter = painterResource(id = boxItems[it].imageId),
                    contentDescription = "Box",
                    contentScale = ContentScale.Inside
                )
                Text(
                    maxLines = 1,
                    text = boxItems[it].boxName,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        color = Black,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        letterSpacing = letterSpacing,
                    ),
                    modifier=Modifier.align(Alignment.BottomCenter).padding(bottom = 5.dp)
                )
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Banner(modifier: Modifier = Modifier) {
    val images = listOf(
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
        "https://picsum.photos/200/300",
    )
//    Card(
//        modifier = modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
//            .fillMaxWidth()
//            .height(90.dp),
//    ) {
//        AutoSlidingCarousel(
//            itemsCount = images.size,
//            itemContent = { index ->
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(images[index])
//                        .build(),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                )
//            }
//        )
//    }
    Row(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        AutoSlidingCarousel(
            itemsCount = images.size,
            itemContent = { index ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(images[index])
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                     modifier = Modifier.fillMaxWidth()
                )
            }
        )

    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    AlFalakMainTheme() {
        DashboardScreen(navHostController = rememberNavController())
    }
}




