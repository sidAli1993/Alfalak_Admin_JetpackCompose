package com.example.al_falakmain.ui.components

import android.content.Context
import android.content.res.Resources
import android.content.res.XmlResourceParser
import android.graphics.fonts.FontFamily
import android.text.style.BackgroundColorSpan
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.al_falakmain.R
import com.example.al_falakmain.ui.theme.Black
import com.example.al_falakmain.ui.theme.BlueDark
import com.example.al_falakmain.ui.theme.ItemBackground
import com.example.al_falakmain.ui.theme.LightGray
import com.example.al_falakmain.ui.theme.NormalButtonBackground
import com.example.al_falakmain.ui.theme.White
import com.google.gson.JsonParser
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.al_falakmain.ui.theme.EditTextBackground


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(
    value: String,
    onValueChanged:(String) -> Unit,
    placeholder: String,
    modifier: Modifier=Modifier,
    shape: Shape= RoundedCornerShape(5.dp),
    textColor:Color=Color.Black,
    hintColor: Color = Black.copy(alpha = 0.5f),
    textStyle: TextStyle = TextStyle.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions= KeyboardOptions(keyboardType = KeyboardType.Text),
    ) {

    OutlinedTextField(value = value,
        onValueChange =onValueChanged,
        placeholder = { Text(text = placeholder, color = hintColor)},
        modifier = modifier
            .fillMaxWidth()
            .background(White, shape)
            .border(BorderStroke(1.dp, NormalButtonBackground), shape = RoundedCornerShape(5.dp)),

        textStyle = textStyle.copy(color = textColor),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        keyboardOptions = keyboardOptions,

    )
}@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextRaw(
    value: String,
    onValueChanged:(String) -> Unit,
    placeholder: String,
    modifier: Modifier=Modifier,
    shape: Shape= RoundedCornerShape(5.dp),
    textColor:Color=Color.Black,
    hintColor: Color = Black.copy(alpha = 0.5f),
    textStyle: TextStyle = TextStyle.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions= KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done,
        keyboardType = KeyboardType.Text,
        capitalization = KeyboardCapitalization.Sentences
    ),

    ) {

    OutlinedTextField(value = value,
        onValueChange =onValueChanged,
        placeholder = { Text(text = placeholder, color = hintColor)},
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(White, shape)
            .border(BorderStroke(1.dp, NormalButtonBackground), shape = RoundedCornerShape(5.dp)),

        textStyle =TextStyle(

        ),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        keyboardOptions = keyboardOptions,
        visualTransformation = VisualTransformation.None,
        maxLines = 4
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextPassword(
    value: String,
    onValueChanged:(String) -> Unit,
    placeholder: String,
    modifier: Modifier=Modifier,
    shape: Shape= RoundedCornerShape(5.dp),
    backgroundColor:Color=Color.White,
    textColor:Color=Color.Black,
    hintColor: Color = Black.copy(alpha = 0.5f),
    textStyle: TextStyle = TextStyle.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions= KeyboardOptions(keyboardType = KeyboardType.Password)
    ) {
    OutlinedTextField(value = value,
        onValueChange =onValueChanged,
        placeholder = { Text(text = placeholder, color = hintColor)},
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor, shape)
            .border(BorderStroke(1.dp, NormalButtonBackground), shape = RoundedCornerShape(5.dp)),
        textStyle = textStyle.copy(color = textColor),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        shape = shape,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextSimple(
    value: String,
    onValueChanged:(String) -> Unit,
    placeholder: String,
    modifier: Modifier=Modifier,
    textColor:Color=Color.Black,
    hintColor: Color = Black.copy(alpha = 0.5f),
    textStyle: TextStyle = TextStyle.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    enabled:Boolean=true,
    fontSize:TextUnit=12.sp
) {
    TextField(value = value,
        onValueChange =onValueChanged,
        placeholder = { Text(text = placeholder, color = hintColor)},
        modifier = modifier
           ,
        textStyle = textStyle.copy(color = textColor, fontSize = fontSize, textAlign = TextAlign.Center),
        trailingIcon = trailingIcon,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = White
        ),
        enabled = enabled,

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextCustom(value: String,
                   onValueChanged:(String) -> Unit,
                   placeholder: String,
                   modifier: Modifier=Modifier,
                   shape: Shape= CustomCanvasShape(),
                   backgroundColor:Color= EditTextBackground,
                   textColor:Color=Color.Black,
                   hintColor: Color = Black.copy(alpha = 0.5f),
                   textStyle: TextStyle = TextStyle.Default,
                   leadingIcon: @Composable (() -> Unit)? = null,
                   trailingIcon: @Composable (() -> Unit)? = null,
                   minLines:Int=0,
                   maxLines:Int=1,
                   keyboardOptions: KeyboardOptions= KeyboardOptions(keyboardType = KeyboardType.Password)) {
    TextField(value = value,
        onValueChange =onValueChanged,
        placeholder = { Text(text = placeholder, color = hintColor)},
        modifier = modifier
            .fillMaxWidth()
            .clip(shape),
        textStyle = textStyle.copy(color = textColor),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = EditTextBackground
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextCustomPassword(value: String,
                           onValueChanged:(String) -> Unit,
                           placeholder: String,
                           modifier: Modifier=Modifier,
                           shape: Shape= CustomCanvasShape(),
                           backgroundColor:Color= EditTextBackground,
                           textColor:Color=Color.Black,
                           hintColor: Color = Black.copy(alpha = 0.5f),
                           textStyle: TextStyle = TextStyle.Default,
                           leadingIcon: @Composable (() -> Unit)? = null,
                           trailingIcon: @Composable (() -> Unit)? = null,
                           keyboardOptions: KeyboardOptions= KeyboardOptions(keyboardType = KeyboardType.Password)) {
    TextField(value = value,
        onValueChange =onValueChanged,
        placeholder = { Text(text = placeholder, color = hintColor)},
        modifier = modifier
            .fillMaxWidth()
            .clip(shape),
        textStyle = textStyle.copy(color = textColor),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = EditTextBackground
        ),
        visualTransformation = PasswordVisualTransformation()
    )
}