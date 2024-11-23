package com.example.sopkathon_android_team3.presentation.component.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.sopkathon_android_team3.R
import com.example.sopkathon_android_team3.presentation.component.button.ConfirmEvenIfButton
import com.example.sopkathon_android_team3.ui.theme.Black
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
        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp.dp
        val dialogHeight = screenHeight * 0.5f

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(dialogHeight)
                .background(
                    color = Color.White,
                )
                .clip(RoundedCornerShape(8.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterEnd)
                        .padding(top = 16.dp, end = 16.dp)
                        .clickable { onClickCancel() }
                )
            }

            Text(
                text = "오늘의 Even If",
                //style = defaultSopkathonAndroidTeam3Typography.head4Bold20,
                color = Black,
                modifier = Modifier
                    .padding(top = 29.dp)
            )

            Text(
                text = "비록",
                //style = defaultSopkathonAndroidTeam3Typography.body1SemiBold16,
                color = Black,
                modifier = Modifier
                    .padding(top = 41.dp)
            )

            // 비록 TextField (추후 변경해야 함) padding top 10 추가
            BasicTextField(
                value = evenValue,
                onValueChange = onEvenValueChange,
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                ),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFBAE5F5),
                                shape = RoundedCornerShape(size = 16.dp)
                            )
                            .padding(all = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Create,
                            contentDescription = "",
                            tint = Color.DarkGray,
                        )
                        Spacer(modifier = Modifier.width(width = 8.dp))
                        innerTextField()
                    }
                },
            )

            Text(
                text = "일지라도",
                //style = defaultSopkathonAndroidTeam3Typography.body1SemiBold16,
                color = Black,
                modifier = Modifier
                    .padding(top = 10.dp)
            )

            // 일지라도 TextField (추후 변경해야 함) padding top 12 추가
            BasicTextField(
                value = ifValue,
                onValueChange = onIfValueChange,
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                ),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFBAE5F5),
                                shape = RoundedCornerShape(size = 16.dp)
                            )
                            .padding(all = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Create,
                            contentDescription = "",
                            tint = Color.DarkGray,
                        )
                        Spacer(modifier = Modifier.width(width = 8.dp))
                        innerTextField()
                    }
                },
            )
            Spacer(modifier = Modifier.weight(1f))

            ConfirmEvenIfButton(onClick = {
                onClickConfirm(evenValue, ifValue) // 확인 버튼 누르면 서버에 텍스트 전송
            },
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 26.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BasicDialogPreview() {
    EvenIfAddDialog(
        onDismissRequest = {},
        evenValue = "",
        onEvenValueChange = {},
        ifValue = "잠긴 시간 동안 취소하기 어려워요",
        onIfValueChange = {},
        onClickConfirm = { even, ifValue -> println("Even: $even, If: $ifValue") },
        onClickCancel = {}
    )
}