package com.example.sopkathon_android_team3.presentation.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sopkathon_android_team3.presentation.component.button.ConfirmEvenIfButton
import com.example.sopkathon_android_team3.ui.theme.Gray5
import com.example.sopkathon_android_team3.ui.theme.Gray9
import com.example.sopkathon_android_team3.ui.theme.Purple2
import com.example.sopkathon_android_team3.ui.theme.SopkathonAndroidTeam3Theme
import com.example.sopkathon_android_team3.ui.theme.StrokeGray
import com.example.sopkathon_android_team3.ui.theme.White

@Composable
fun EvenIfHistoryDialog(
    onDismissRequest: () -> Unit,
    evenText: String,
    ifText: String,
    onClickConfirm: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HistoryViewModel = viewModel()
) {
    val beadData by viewModel.beadDataState.collectAsState()

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
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(2.dp, Gray5, RoundedCornerShape(16.dp))
                .background(
                    color = Gray9,
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "비록",
                style = SopkathonAndroidTeam3Theme.typography.head3Bold23,
                color = White,
                modifier = Modifier
                    .padding(top = 34.dp)
            )

            Box(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(horizontal = 20.dp)
                   .padding(top = 20.dp)
                   .clip(RoundedCornerShape(8.dp))
                   .border(2.dp, StrokeGray, RoundedCornerShape(8.dp))
                   .background(Purple2),
            ) {
                Text(
                    text = evenText,
                    style = SopkathonAndroidTeam3Theme.typography.head5Bold18,
                    color = White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 14.dp)
                )
            }
            
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 33.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(2.dp,StrokeGray, RoundedCornerShape(8.dp))
                    .background(Purple2),
            ) {
                Text(
                    text = ifText,
                    style = SopkathonAndroidTeam3Theme.typography.head5Bold18,
                    color = White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 58.dp)
                )
            }

            ConfirmEvenIfButton(
                buttonText = "확인",
                onClick = onClickConfirm,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 34.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun EvenIfHistoryDialogPreview() {
    EvenIfHistoryDialog(
        onDismissRequest = {},
        evenText = "잠긴 시간 동안 취소하기 어려워요",
        ifText = "취소",
        onClickConfirm = {},
        modifier = Modifier
            .padding(horizontal = 20.dp)
    )
}