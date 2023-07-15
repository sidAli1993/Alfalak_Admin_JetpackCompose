package com.example.al_falakmain.components

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class CustomCanvasShape() : Shape {
    val svgPath = listOf<String>("M5038,60C5038,296.7 5038,533.4 5037.7,770.8C5033.7,791.6 5022.8,806.9 5006.2,818.6C4997.9,824.5 4988.5,827.2 4979,830C3379.3,830 1779.6,830 179.4,829.5C178.7,789.1 178.1,749.1 178,709.2C177.9,560 178,410.9 178,261.7C178,260.2 177.7,258.7 178.1,257.2C179.6,250.7 176.2,246 171.7,242.6C159.4,233.1 146.4,224.4 134.1,215C119,203.4 103.7,191.8 89.4,179.4C71.7,164 57.4,145.8 45.2,125.8C31.1,102.7 18.3,78.9 9.9,52.9C6.7,43 4,33 1,23C1,15.7 1,8.3 1,1C1660,1 3319.1,1 4978.8,1.3C5000.8,5.6 5017.2,16.8 5028,35.4C5032.4,43 5034.7,51.8 5038,60z",
        "M5038,59.5C5034.7,51.8 5032.4,43 5028,35.4C5017.2,16.8 5000.8,5.6 4979.3,1.3C4998.6,1 5018.2,1 5038,1C5038,20.4 5038,39.7 5038,59.5z",
        "M4979.5,830C4988.5,827.2 4997.9,824.5 5006.2,818.6C5022.8,806.9 5033.7,791.6 5037.7,771.3C5038,790.6 5038,810.2 5038,830C5018.6,830 4999.3,830 4979.5,830z")
    val path = Path().apply {
        for(p in svgPath){
            addPath(PathParser().parsePathString(p).toPath())
        }
    }
    val pathSize = path.getBounds().size

    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        val matrix = android.graphics.Matrix()
        matrix.postScale(
            size.width / pathSize.width, size.height / pathSize.height
        )
        path.asAndroidPath().transform(matrix)

        return Outline.Generic(path)

    }
}