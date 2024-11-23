package com.example.sopkathon_android_team3.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sopkathon_android_team3.R
import com.example.sopkathon_android_team3.ui.theme.SOPKATHON_ANDROID_TEAM3Theme
import com.example.sopkathon_android_team3.ui.theme.SopkathonAndroidTeam3Theme
import com.example.sopkathon_android_team3.util.modifier.noRippleClickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeDescriptionDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    BasicAlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(SopkathonAndroidTeam3Theme.colors.black)
                .padding(vertical = 16.dp)
                .padding(start = 32.dp)
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .align(Alignment.End)
                    .noRippleClickable(onDismissRequest),
                imageVector = ImageVector.vectorResource(R.drawable.ic_close_white),
                contentDescription = null,
                tint = SopkathonAndroidTeam3Theme.colors.gray5
            )
            Text(
                modifier = Modifier.padding(top = 15.dp),
                text = stringResource(R.string.home_description_dialog_title1),
                style = SopkathonAndroidTeam3Theme.typography.head2Bold26,
                color = SopkathonAndroidTeam3Theme.colors.white
            )
            Text(
                modifier = Modifier.padding(top = 9.dp),
                text = stringResource(R.string.home_description_dialog_title2),
                style = SopkathonAndroidTeam3Theme.typography.head2Bold26,
                color = SopkathonAndroidTeam3Theme.colors.purple4
            )
            Text(
                modifier = Modifier.padding(top = 24.dp),
                text = stringResource(R.string.home_description_dialog_content),
                style = SopkathonAndroidTeam3Theme.typography.body4SemiBold11,
                color = SopkathonAndroidTeam3Theme.colors.white
            )
            Image(
                modifier = Modifier.padding(top = 23.dp, end = 14.dp),
                painter = painterResource(R.drawable.img_card_ball),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun HomeDescriptionDialogPreview() {
    SOPKATHON_ANDROID_TEAM3Theme {
        HomeDescriptionDialog(
            onDismissRequest = {}
        )
    }
}
