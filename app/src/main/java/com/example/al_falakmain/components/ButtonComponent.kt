package com.example.al_falakmain.components

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.White

@Composable
fun ButtonSimple(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(20.dp),
    backgroundColor: Color = BlueDark,
    textColor: Color = White,
    onClick: () -> Unit,
    textSize: TextUnit = 12.sp,
    height:Dp=48.dp
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(height = height)
            .background(backgroundColor, shape),
        colors = ButtonDefaults.buttonColors(
            containerColor = BlueDark
        )
    ) {
        Text(
            text = text, color = textColor,
            fontSize = textSize,
            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif
        )
    }
}