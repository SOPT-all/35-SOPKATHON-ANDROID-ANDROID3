package com.example.sopkathon_android_team3.presentation.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sopkathon_android_team3.ui.theme.Black
import com.example.sopkathon_android_team3.ui.theme.White

@Composable
fun ConfirmEvenIfButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "완료",
            //style = defaultSopkathonAndroidTeam3Typography.body1SemiBold16,
            color = White,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .clickable { onClick() }
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun ConfirmEvenIfButtonPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        ConfirmEvenIfButton(
            onClick = {}
        )
    }
}