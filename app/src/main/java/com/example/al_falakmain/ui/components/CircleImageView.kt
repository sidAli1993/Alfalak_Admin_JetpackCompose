package com.example.al_falakmain.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.White

@Composable
fun CircleImageView(
    modifier: Modifier = Modifier,
    imageId: Int,
    borderWidth: Int = 2,
    borderColor: Color = BlueDark,
    shape: Shape = CircleShape,
) {
    Card(
        modifier = modifier.size(80.dp),
        border = BorderStroke(borderWidth.dp, borderColor),
        shape = shape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Person Image",
            modifier = Modifier.fillMaxSize().background(White),
            contentScale = ContentScale.FillBounds
        )
    }

}