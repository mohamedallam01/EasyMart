package core.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import composeApp.src.commonMain.composeResources.Res
import composeApp.src.commonMain.composeResources.montserrat_black
import composeApp.src.commonMain.composeResources.montserrat_bold
import composeApp.src.commonMain.composeResources.montserrat_extrabold
import composeApp.src.commonMain.composeResources.montserrat_extralight
import composeApp.src.commonMain.composeResources.montserrat_light
import composeApp.src.commonMain.composeResources.montserrat_medium
import composeApp.src.commonMain.composeResources.montserrat_regular
import composeApp.src.commonMain.composeResources.montserrat_semi_bold
import composeApp.src.commonMain.composeResources.montserrat_thin
import org.jetbrains.compose.resources.Font


@Composable
fun montserrat(): FontFamily {
    val montserratRegular =
        Font(
            resource = Res.font.montserrat_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal,
        )

    val montserratBold =
        Font(
            resource = Res.font.montserrat_bold,
            FontWeight.Bold,
            FontStyle.Normal,
        )

    val montserratLight =
        Font(
            resource = Res.font.montserrat_light,
            FontWeight.Light,
            FontStyle.Normal,
        )

    val montserratMedium =
        Font(
            resource = Res.font.montserrat_medium,
            FontWeight.Medium,
            FontStyle.Normal,
        )

    val montserratSemiBold =
        Font(
            resource = Res.font.montserrat_semi_bold,
            FontWeight.SemiBold,
            FontStyle.Normal,
        )

    val montserratThin =
        Font(
            resource = Res.font.montserrat_thin,
            FontWeight.Thin,
            FontStyle.Normal,
        )

    val montserratExtraBold =
        Font(
            resource = Res.font.montserrat_extrabold,
            FontWeight.ExtraBold,
            FontStyle.Normal,
        )

    val montserratExtraLight =
        Font(
            resource = Res.font.montserrat_extralight,
            FontWeight.ExtraLight,
            FontStyle.Normal,
        )
    val montserratBlack = Font(
        resource = Res.font.montserrat_black,
        FontWeight.Black,
        FontStyle.Normal,
    )

    return FontFamily(
        montserratThin,
        montserratExtraLight,
        montserratLight,
        montserratRegular,
        montserratMedium,
        montserratSemiBold,
        montserratBold,
        montserratExtraBold,
        montserratBlack,
    )
}


@Composable
fun getTypography(): Typography {
    val montserrat = montserrat()
    return Typography(
        displayLarge = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W400,
            fontSize = 50.sp,
        ),
        displayMedium = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W400,
            fontSize = 40.sp,
        ),
        displaySmall = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W400,
            fontSize = 30.sp,
        ),
        headlineLarge = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W400,
            fontSize = 28.sp,
        ),
        headlineMedium = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W400,
            fontSize = 24.sp,
        ),
        headlineSmall = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W400,
            fontSize = 20.sp,
        ),
        titleLarge = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W700,
            fontSize = 18.sp,
        ),
        titleMedium = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W700,
            fontSize = 14.sp,
        ),
        titleSmall = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W500,
            fontSize = 12.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
        ),
        bodyMedium = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
        ),
        bodySmall = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W400,
            fontSize = 11.sp,
        ),
        labelLarge = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W400,
            fontSize = 13.sp,
        ),
        labelMedium = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W400,
            fontSize = 11.sp,
        ),
        labelSmall = TextStyle(
            fontFamily = montserrat,
            fontWeight = FontWeight.W500,
            fontSize = 9.sp,
        ),

        )
}