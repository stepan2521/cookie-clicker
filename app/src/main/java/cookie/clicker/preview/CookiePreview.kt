package cookie.clicker.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cookie.clicker.composables.Cookie
import cookie.clicker.ui.theme.CookieClickerTheme

@Preview(showBackground = false)
@Composable
fun CookiePreview() {
    CookieClickerTheme {
        Cookie()
    }
}