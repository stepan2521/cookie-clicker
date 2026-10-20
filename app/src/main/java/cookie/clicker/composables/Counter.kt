package cookie.clicker.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlin.math.floor

@Composable
fun Counter(cookies: Float = 0f) {
    Text("Cookies: ${
        if ((cookies - floor((cookies)) == 0f)) { cookies.toInt() }
        else { cookies }
    }")
}