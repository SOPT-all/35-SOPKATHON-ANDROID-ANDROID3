package com.example.sopkathon_android_team3.presentation.component.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.sopkathon_android_team3.R
import com.example.sopkathon_android_team3.presentation.component.DialogTextField
import com.example.sopkathon_android_team3.presentation.component.button.ConfirmEvenIfButton
import com.example.sopkathon_android_team3.ui.theme.Gray6
import com.example.sopkathon_android_team3.ui.theme.Purple4
import com.example.sopkathon_android_team3.ui.theme.SOPKATHON_ANDROID_TEAM3Theme
import com.example.sopkathon_android_team3.ui.theme.White
import com.example.sopkathon_android_team3.ui.theme.defaultSopkathonAndroidTeam3Typography

@Composable
fun EvenIfAddDialog(
    onDismissRequest: () -> Unit,
    evenValue: String,
    onEvenValueChange: (String) -> Unit,
    ifValue: String,
    onIfValueChange: (String) -> Unit,
    onClickConfirm: (String, String) -> Unit,
    onClickCancel: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = true, // 디바이스 뒤로가기 키 클릭시 dismiss 처리 여부
            dismissOnClickOutside = true, // 다이얼로그 외부 클릭시 dismiss 처리 여부
            securePolicy = SecureFlagPolicy.Inherit, // 다이얼로그 보안 정책
            usePlatformDefaultWidth = true, // 화면 전체 width 보다 작게 제한함
            decorFitsSystemWindows = true, // 다이얼로그 시스템 창 경계를 고려
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(
                    color = Purple4,
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_close_white),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(top = 16.dp, end = 16.dp)
                        .clickable { onClickCancel() }
                )
            }

            Text(
                text = "비록",
               style = defaultSopkathonAndroidTeam3Typography.head3Bold23,
                color = White,
            )

            DialogTextField(
                value = evenValue,
                hintText = "절망적인 상황이지만",
                onValueChange = onEvenValueChange,
                inputTextStyle = defaultSopkathonAndroidTeam3Typography.head5Bold18,
                hintTextStyle = defaultSopkathonAndroidTeam3Typography.head5Bold18,
                paddingTop = 19.dp,
                paddingHorizontal = 40.dp,
                internalPaddingVertical = 14.dp,
                internalPaddingHorizontal = 48.dp,
                inputTextColor = White,
                hintTextColor = Gray6,
            )

            DialogTextField(
                value = ifValue,
                hintText = "긍정적인 결과가 나타났다",
                onValueChange = onIfValueChange,
                inputTextStyle = defaultSopkathonAndroidTeam3Typography.head5Bold18,
                hintTextStyle = defaultSopkathonAndroidTeam3Typography.head5Bold18,
                paddingTop = 31.dp,
                paddingHorizontal = 40.dp,
                internalPaddingVertical = 57.dp,
                internalPaddingHorizontal = 31.dp,
                inputTextColor = White,
                hintTextColor = Gray6,
            )

            ConfirmEvenIfButton(
                buttonText = "완료",
                onClick = { onClickConfirm(evenValue, ifValue) },
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 42.dp, bottom = 22.dp)
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun BasicDialogPreview() {
    SOPKATHON_ANDROID_TEAM3Theme {
    EvenIfAddDialog(
        onDismissRequest = {},
        evenValue = "d",
        onEvenValueChange = {},
        ifValue = "",
        onIfValueChange = {},
        onClickConfirm = { even, ifValue -> println("Even: $even, If: $ifValue") },
        onClickCancel = {}
    )
        }
}