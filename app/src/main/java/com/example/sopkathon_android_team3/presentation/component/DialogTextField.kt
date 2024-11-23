package com.example.sopkathon_android_team3.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sopkathon_android_team3.ui.theme.Black
import com.example.sopkathon_android_team3.ui.theme.Gray1
import com.example.sopkathon_android_team3.ui.theme.Gray6
import com.example.sopkathon_android_team3.ui.theme.Purple4
import com.example.sopkathon_android_team3.ui.theme.StrokeGray
import com.example.sopkathon_android_team3.ui.theme.White
import com.example.sopkathon_android_team3.ui.theme.defaultSopkathonAndroidTeam3Typography

@Composable
fun DialogTextField(
    value: String,
    hintText: String,
    onValueChange: (String) -> Unit,
    inputTextStyle: TextStyle = defaultSopkathonAndroidTeam3Typography.head5Bold18,
    hintTextStyle: TextStyle = defaultSopkathonAndroidTeam3Typography.head5Bold18,
    paddingTop: Dp,
    paddingHorizontal: Dp,
    internalPaddingVertical: Dp,
    internalPaddingHorizontal: Dp,
    inputTextColor: Color = White,
    hintTextColor: Color = Gray6,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(horizontal = paddingHorizontal)
            .padding(top = paddingTop)
            .clip(RoundedCornerShape(8.dp))
            .border(2.dp, StrokeGray, RoundedCornerShape(8.dp))
            .background(Purple4),
        contentAlignment = Alignment.Center
    ) {
        if (value.isEmpty()) {
            Text(
                text = hintText,
                style = hintTextStyle.copy(color = hintTextColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center)
                    .padding(vertical = internalPaddingVertical, horizontal = internalPaddingHorizontal)
            )
        }

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = inputTextStyle.copy(color = inputTextColor),
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.Center)
                .padding(vertical = internalPaddingVertical, horizontal = internalPaddingHorizontal)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun DialogTextFieldPreview() {
    DialogTextField(
        value = "text",
        hintText = "Enter your text...",
        onValueChange = {  },
        inputTextStyle = TextStyle(fontSize = 16.sp),
        hintTextStyle = TextStyle(fontSize = 16.sp),
        paddingTop = 8.dp,
        paddingHorizontal = 16.dp,
        internalPaddingVertical = 14.dp,
        internalPaddingHorizontal = 16.dp,
        inputTextColor = White,
        hintTextColor = Gray6,
    )
}