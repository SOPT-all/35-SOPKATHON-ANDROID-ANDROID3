package com.example.sopkathon_android_team3.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.sopkathon_android_team3.R

val PretendardBold = FontFamily(Font(R.font.pretendard_bold))
val PretendardRegular = FontFamily(Font(R.font.pretendard_regular))
val PretendardSemiBold = FontFamily(Font(R.font.pretendard_semibold))

@Immutable
data class SopkathonAndroidTeam3Typography(
    //head
    val head1Bold29: TextStyle,
    val head2Bold26: TextStyle,
    val head3Bold23: TextStyle,
    val head4Bold20: TextStyle,
    val head5Bold18: TextStyle,
    //body
    val body1Regular16: TextStyle,
    val body1SemiBold16: TextStyle,
    val body2Regular14: TextStyle,
    val body2SemiBold14: TextStyle,
    val body3Regular13: TextStyle,
    val body3SemiBold13: TextStyle,
    val body4Regular11: TextStyle,
    val body4SemiBold11: TextStyle
)

val defaultSopkathonAndroidTeam3Typography =
    SopkathonAndroidTeam3Typography(
        head1Bold29 =
        TextStyle(
            fontFamily = PretendardBold,
            fontSize = 29.sp
        ),
        head2Bold26 =
        TextStyle(
            fontFamily = PretendardBold,
            fontSize = 26.sp
        ),
        head3Bold23 =
        TextStyle(
            fontFamily = PretendardBold,
            fontSize = 23.sp
        ),
        head4Bold20 =
        TextStyle(
            fontFamily = PretendardBold,
            fontSize = 20.sp
        ),
        head5Bold18 =
        TextStyle(
            fontFamily = PretendardBold,
            fontSize = 18.sp
        ),
        //body
        body1Regular16 =
        TextStyle(
            fontFamily = PretendardRegular,
            fontSize = 16.sp
        ),
        body1SemiBold16 =
        TextStyle(
            fontFamily = PretendardSemiBold,
            fontSize = 16.sp
        ),
        body2Regular14 =
        TextStyle(
            fontFamily = PretendardRegular,
            fontSize = 14.sp
        ),
        body2SemiBold14 =
        TextStyle(
            fontFamily = PretendardSemiBold,
            fontSize = 14.sp
        ),
        body3Regular13 =
        TextStyle(
            fontFamily = PretendardRegular,
            fontSize = 13.sp
        ),
        body3SemiBold13 =
        TextStyle(
            fontFamily = PretendardSemiBold,
            fontSize = 13.sp
        ),
        body4Regular11 =
        TextStyle(
            fontFamily = PretendardRegular,
            fontSize = 11.sp
        ),
        body4SemiBold11 =
        TextStyle(
            fontFamily = PretendardSemiBold,
            fontSize = 11.sp,
            lineHeight = 20.sp
        ),
    )

val LocalSopkathonAndroidTeam3Typography = staticCompositionLocalOf { defaultSopkathonAndroidTeam3Typography }
