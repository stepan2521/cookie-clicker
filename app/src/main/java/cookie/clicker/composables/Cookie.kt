package cookie.clicker.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cookie.clicker.resources.Icons
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun Cookie() {
    var cookies by rememberSaveable { mutableFloatStateOf(0f) }
    var icon by rememberSaveable { mutableIntStateOf(Icons.Ids.cookieId) }
    val scope = rememberCoroutineScope()
    
    Image(
            painter = painterResource(icon),
            contentDescription = "Cookie",
            modifier = Modifier
                    .size(200.dp)
                    .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = ripple(bounded = false, radius = 100.dp),
                            onClick = {
                                scope.launch {
                                    cookies++
                                    icon = Icons.Ids.eaten_cookieId
                                    delay(500.milliseconds)
                                    icon = Icons.Ids.cookieId
                                }
                            }
                    )
                    .padding(bottom = 32.5.dp)
    
    )
    Counter(cookies)
}