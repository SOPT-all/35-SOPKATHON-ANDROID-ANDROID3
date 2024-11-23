package com.example.sopkathon_android_team3.presentation.component

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.sopkathon_android_team3.ui.theme.Black
import com.example.sopkathon_android_team3.ui.theme.Gray1

@Composable
fun DialogTextField(
    value: String,
    hintText: String,
    onValueChange: (String) -> Unit,
    inputTextStyle: TextStyle,
    hintTextStyle: TextStyle,
    cornerRadius: Dp,
    paddingVertical: Dp,
    paddingHorizontal: Dp,
    inputTextColor: Color = Black,
    hintTextColor: Color = Gray1,
    modifier: Modifier = Modifier,
) {
    // 디자인이 나오면 만들어야 함
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = inputTextStyle.copy(color = inputTextColor),
        modifier = modifier,

        )
}

@Preview(showSystemUi = true)
@Composable
fun DialogTextFieldPreview(

) {

}