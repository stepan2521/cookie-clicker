package cookie.clicker.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Counter(cookies: Float = 0f) {
    Text("Cookies: $cookies")
}