package com.example.al_falakmain.ui.components

import android.util.Size
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle


@Composable
fun SimpleTextview(
    modifier: Modifier=Modifier,
    text:String,
    textColor:Color= Color.Black,
    fontWeight:FontWeight=FontWeight.Normal,
    fontFamily: FontFamily= FontFamily.SansSerif,
    textAlign: TextAlign= TextAlign.Start,fontSize:TextUnit=12.sp,
     letterSpacing:TextUnit = 0.5.sp,
     lineHeight:TextUnit = 20.sp,
) {
    Text(text = text, style = androidx.compose.ui.text.TextStyle(
        color = textColor,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        textAlign = textAlign,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing
    ), modifier = modifier.fillMaxWidth())
}

@Composable
fun TextViewBorder(
    modifier: Modifier=Modifier,
    text:String,
    textColor:Color= Color.Black,
    fontWeight:FontWeight=FontWeight.Normal,
    fontFamily: FontFamily= FontFamily.SansSerif,
    textAlign: TextAlign= TextAlign.Start,
    shape: Shape= RoundedCornerShape(5.dp),
    fontSize:TextUnit=12.sp
) {
    Text(text = text, style = androidx.compose.ui.text.TextStyle(
        color = textColor,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        textAlign = textAlign, fontSize = fontSize
    ), modifier = modifier.fillMaxWidth().padding(1.dp)
        .border(width = 1.dp,shape=shape, color = Color.Black)
        .padding(vertical = 5.dp, horizontal = 5.dp))
}


@Preview
@Composable
fun SimpleTextviewPreview(){
    SimpleTextview(text = "asdasdasd")
}
