package com.example.al_falakmain.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.al_falakmain.R

import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.White

@Composable
fun BottomBar(modifier: Modifier = Modifier, navHostController: NavHostController) {
BottomAppBar() {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(BlueDark)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            IconWthText(
                R.drawable.ic_auto_on_off,
                contentDescription = "Auto On OFF",
                title = "Auto On OFF"
            )
            IconWthText(
                R.drawable.ic_help_line,
                contentDescription = "Help Line",
                title = "Help Line"
            )
            IconWthText(
                R.drawable.ic_time_change,
                contentDescription = "Time Change",
                title = "Time Change"
            )
            IconWthText(
                R.drawable.ic_whatsapp,
                contentDescription = "Whatsapp",
                title = "Whatsapp"
            )
        }
    }
}
}


@Composable
fun IconWthText(icon: Int, title: String, contentDescription: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = title,
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = White
            ),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}



@Preview
@Composable
fun PreviewScreen() {
    BottomBar(navHostController = rememberNavController())
}

