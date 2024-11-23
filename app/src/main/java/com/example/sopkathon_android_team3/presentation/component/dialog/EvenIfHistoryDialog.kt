package com.example.sopkathon_android_team3.presentation.component.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.sopkathon_android_team3.presentation.component.button.AddEvenIfButton
import com.example.sopkathon_android_team3.presentation.component.button.ConfirmEvenIfButton
import com.example.sopkathon_android_team3.ui.theme.Black
import com.example.sopkathon_android_team3.ui.theme.defaultSopkathonAndroidTeam3Typography

@Composable
fun EvenIfHistoryDialog(
    onDismissRequest: () -> Unit,
    title: String,
    description1: String,
    description2: String,
    onClickConfirm: () -> Unit,
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
                ),
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
                )
            }

            Text(
                text = "과거의 Even if",
                //style = defaultSopkathonAndroidTeam3Typography.body1SemiBold16,
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

            Text(
                text = description1,
                //style = defaultSopkathonAndroidTeam3Typography.body1SemiBold16,
                color = Black,
                modifier = Modifier
                    .padding(top = 18.dp)
            )

            Text(
                text = "일지라도",
                //style = defaultSopkathonAndroidTeam3Typography.body1SemiBold16,
                color = Black,
                modifier = Modifier
                    .padding(top = 18.dp)
            )

            Text(
                text = description2,
                //style = defaultSopkathonAndroidTeam3Typography.body1SemiBold16,
                color = Black,
                modifier = Modifier
                    .padding(top = 18.dp)
            )
            Spacer(modifier = Modifier.weight(1f))

            ConfirmEvenIfButton(
                onClick = onClickConfirm,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 26.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun EvenIfHistoryDialogPreview() {
    EvenIfHistoryDialog(
        onDismissRequest = {},
        title = "목표를 입력하세요",
        description1 = "잠긴 시간 동안 취소하기 어려워요",
        description2 = "취소",
        onClickConfirm = {},
    )
}