package com.example.sopkathon_android_team3.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sopkathon_android_team3.R
import com.example.sopkathon_android_team3.presentation.component.BasicLottie
import com.example.sopkathon_android_team3.presentation.component.dialog.EvenIfAddDialog
import com.example.sopkathon_android_team3.presentation.home.component.HomeDescriptionDialog
import com.example.sopkathon_android_team3.presentation.type.CrystalAnimation
import com.example.sopkathon_android_team3.ui.theme.SOPKATHON_ANDROID_TEAM3Theme
import com.example.sopkathon_android_team3.ui.theme.SopkathonAndroidTeam3Theme
import com.example.sopkathon_android_team3.util.modifier.noRippleClickable

@Composable
fun HomeRoute(
    padding: PaddingValues,
    onNavigateToStorage: () -> Unit,
    viewModel: HomeViewModel = viewModel()

) {
    var showDialog by remember { mutableStateOf(false) }
    var showAddDialog by remember { mutableStateOf(false) }
    val animation by viewModel.animation.collectAsState()

    val even by viewModel.even.collectAsState()
    val ifValue by viewModel.ifValue.collectAsState()

    if (showDialog) {
        HomeDescriptionDialog(
            modifier = Modifier
                .fillMaxWidth(),
            onDismissRequest = { showDialog = false }
        )
    }

    if (showAddDialog) {
        EvenIfAddDialog(
            onDismissRequest = { showAddDialog = false },
            evenValue = even,
            onEvenValueChange = viewModel::updateEven,
            ifValue = ifValue,
            onIfValueChange = viewModel::updateIfValue,
            onClickConfirm = {
//               viewModel.postEvenIf(even, ifValue)
                viewModel.resetTextField()
                showAddDialog = false
            },
            onClickCancel = { showAddDialog = false }
        )
    }

    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.img_background_home),
            contentDescription = null
        )
        HomeScreen(
            onClickDescription = {
                showDialog = true
            },
            onNavigateToStorage = onNavigateToStorage,
            onClickAdd = { showAddDialog = true },
            animation = animation,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        )
    }

    LaunchedEffect(Unit) {
        viewModel.fetchAnimation(count = 3)
    }
}

@Composable
private fun HomeScreen(
    onClickDescription: () -> Unit,
    onNavigateToStorage: () -> Unit,
    onClickAdd: () -> Unit,
    animation: CrystalAnimation,
    modifier: Modifier = Modifier,
) {
    Box {
        Row(
            modifier = modifier.padding(top = 42.dp, start = 18.dp, end = 13.dp)
        ) {
            Icon(
                modifier = Modifier.padding(top = 9.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_logo),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .noRippleClickable(onClickDescription)
                    .padding(end = 17.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_crystalball_small),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Row(
                    modifier = Modifier.padding(top = 5.dp)
                ) {
                    Text(
                        text = stringResource(R.string.home_crystal_ball),
                        style = SopkathonAndroidTeam3Theme.typography.body4SemiBold11,
                        color = SopkathonAndroidTeam3Theme.colors.white
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_crystalball_question),
                        contentDescription = null,
                        tint = SopkathonAndroidTeam3Theme.colors.white
                    )
                }
            }
            Column(
                modifier = Modifier.noRippleClickable(onNavigateToStorage),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_storagebox),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = stringResource(R.string.home_crystal_storage),
                    style = SopkathonAndroidTeam3Theme.typography.body4SemiBold11,
                    color = SopkathonAndroidTeam3Theme.colors.white
                )
            }
        }
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            BasicLottie(
                crystalAnimation = animation.jsonFileName
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 82.dp)
                .padding(horizontal = 20.dp)
                .height(56.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            SopkathonAndroidTeam3Theme.colors.gradientPurple,
                            SopkathonAndroidTeam3Theme.colors.gradientBlue
                        )
                    )
                )
                .clickable { onClickAdd() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.home_button_write),
                style = SopkathonAndroidTeam3Theme.typography.head2Bold26,
                color = SopkathonAndroidTeam3Theme.colors.white
            )
        }
    }
}

@Preview
@Composable
private fun HomeRoutePreview() {
    SOPKATHON_ANDROID_TEAM3Theme {
        HomeRoute(
            padding = PaddingValues(),
            onNavigateToStorage = {}
        )
    }
}
