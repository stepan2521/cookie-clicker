package cookie.clicker.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cookie.clicker.composables.Clicker
import cookie.clicker.ui.theme.CookieClickerTheme

@Preview(showBackground = true)
@Composable
fun ClickButtonPreview() {
    CookieClickerTheme {
        Clicker()
    }
}