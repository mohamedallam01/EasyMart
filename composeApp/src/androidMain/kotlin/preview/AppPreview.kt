package preview

import EasyMartApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import core.presentation.theme.EasyMartTheme


@Preview(showBackground = true)
@Composable
fun AppPreview() {

    EasyMartTheme {
        EasyMartApp()
    }
}