package com.example.sopkathon_android_team3.presentation.storage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sopkathon_android_team3.R
import com.example.sopkathon_android_team3.ui.theme.SOPKATHON_ANDROID_TEAM3Theme
import com.example.sopkathon_android_team3.ui.theme.SopkathonAndroidTeam3Theme
import com.example.sopkathon_android_team3.util.modifier.noRippleClickable

@Composable
fun StorageRoute(
    padding: PaddingValues,
    onNavigateToHome: () -> Unit
) {
    StorageScreen(
        modifier = Modifier.padding(padding),
        onNavigateToHome = onNavigateToHome,
    )
}

@Composable
private fun StorageScreen(
    onNavigateToHome: () -> Unit,
    modifier: Modifier = Modifier
) {
    val currentImage = remember { mutableStateOf(R.drawable.ic_king_bead_purple_center) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(SopkathonAndroidTeam3Theme.colors.disabledBlack),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "수정구 보관함",
            style = SopkathonAndroidTeam3Theme.typography.head1Bold29,
            color = SopkathonAndroidTeam3Theme.colors.white
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "지금까지 모은 수정구를 확인해보세요!",
            style = SopkathonAndroidTeam3Theme.typography.body1SemiBold16,
            color = SopkathonAndroidTeam3Theme.colors.gray4
        )

        Spacer(modifier = Modifier.height(62.dp))

        Image(
            painter = painterResource(currentImage.value),
            contentDescription = "king bead",
            modifier = modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(46.dp))

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 66.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_arrow_left_purple),
                contentDescription = "Storage left arrow",
                modifier = modifier
                    .noRippleClickable { currentImage.value = R.drawable.ic_king_bead_purple_center }
            )

            Image(
                painter = painterResource(R.drawable.ic_arrow_right_purple),
                contentDescription = "Storage right arrow",
                modifier = modifier
                    .noRippleClickable { currentImage.value = R.drawable.ic_king_bead_green_center }
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
//    Text(
//        modifier = modifier.clickable(onClick = onNavigateToHome),
//        text = "This is Storage Screen",
//        color = SopkathonAndroidTeam3Theme.colors.white
//    )
}

@Preview
@Composable
private fun StorageRoutePreview() {
    SOPKATHON_ANDROID_TEAM3Theme {
        StorageRoute(
            padding = PaddingValues(),
            onNavigateToHome = {}
        )
    }
}
