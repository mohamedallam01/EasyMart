
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import core.presentation.theme.EasyMartTheme
import feature.onboarding.OnboardingScreen

@Composable
fun EasyMartApp(
) {


    EasyMartTheme() {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Navigator(
                screen = OnboardingScreen()
            )
        }
    }


}