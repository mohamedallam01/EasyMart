package feature.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import composeApp.src.commonMain.composeResources.Res
import composeApp.src.commonMain.composeResources.first_onboarding_desc
import composeApp.src.commonMain.composeResources.first_onboarding_title
import composeApp.src.commonMain.composeResources.get_started
import composeApp.src.commonMain.composeResources.il_add_to_cart
import composeApp.src.commonMain.composeResources.il_home_delivery_service
import composeApp.src.commonMain.composeResources.il_online_shopping_order
import composeApp.src.commonMain.composeResources.next
import composeApp.src.commonMain.composeResources.second_onboarding_desc
import composeApp.src.commonMain.composeResources.second_onboarding_title
import composeApp.src.commonMain.composeResources.third_onboarding_desc
import composeApp.src.commonMain.composeResources.third_onboarding_title
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

class OnboardingScreen : Screen {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        //val navigator = LocalNavigator.currentOrThrow
        val coroutineScope = rememberCoroutineScope()
        val pageCount = 3
        val pagerState = rememberPagerState(pageCount = { pageCount })

        OnboardingScreenContent(
            pagerState = pagerState,
            pageCount = pageCount,
            onClickNext = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            },
            onClickGetStarted = {
                //navigator.push(UsernameScreen())
            },
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreenContent(
    pageCount: Int,
    pagerState: PagerState,
    onClickNext: () -> Unit,
    onClickGetStarted: () -> Unit,
) {
    Scaffold(
        bottomBar = {
            if (pagerState.currentPage == pageCount - 1) {
                OnBoardingNavigationButton(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(Res.string.get_started),
                    onClick = onClickGetStarted,
                )
            } else {
                OnBoardingNavigationButton(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(Res.string.next),
                    onClick = onClickNext,
                )
            }
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues),
        ) {
            HorizontalPager(
                modifier = Modifier
                    .weight(.9f),
                state = pagerState,
            ) { currentPage ->
                when (currentPage) {
                    0 -> OnboardingFirstPage()
                    1 -> OnboardingSecondPage()
                    2 -> OnboardingThirdPage()
                }
            }

            PageIndicators(
                pageCount = pageCount,
                currentPage = pagerState.currentPage,
            )
        }
    }
}

@Composable
private fun ColumnScope.PageIndicators(pageCount: Int, currentPage: Int) {
    Row(
        Modifier
            .weight(.1f)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(pageCount) { iteration ->
            val color =
                if (currentPage == iteration) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(
                        alpha = 0.2f,
                    )
                }
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .width(24.dp)
                    .height(8.dp),

                )
        }
    }
}

@Composable
private fun OnboardingFirstPage() {
    PageContent(
        title = stringResource(Res.string.first_onboarding_title),
        description = stringResource(Res.string.first_onboarding_desc),
        illustration = Res.drawable.il_online_shopping_order,
    )
}

@Composable
private fun OnboardingSecondPage() {
    PageContent(
        title = stringResource(Res.string.second_onboarding_title),
        description = stringResource(Res.string.second_onboarding_desc),
        illustration = Res.drawable.il_add_to_cart,
    )
}

@Composable
private fun OnboardingThirdPage() {
    PageContent(
        title = stringResource(Res.string.third_onboarding_title),
        description = stringResource(Res.string.third_onboarding_desc),
        illustration = Res.drawable.il_home_delivery_service,
    )
}

@Composable
private fun PageContent(title: String, description: String, illustration: DrawableResource) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(illustration),
            contentDescription = null,
            modifier = Modifier.size(370.dp),
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = description,
            style = MaterialTheme.typography.labelMedium.copy(
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            ),
            color = MaterialTheme.colorScheme.onBackground

        )
    }
}

@Composable
fun OnBoardingNavigationButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Unspecified,
            containerColor = MaterialTheme.colorScheme.primary
        )

    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            ),
            color = MaterialTheme.colorScheme.onPrimary

        )
    }
}

