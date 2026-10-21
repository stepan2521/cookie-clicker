package cookie.clicker.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BottomBar() {
    BottomAppBar(
            modifier = Modifier.fillMaxSize()
    ) {
        NavigationBar {
            NavigationBarItem(
                    onClick = {},
                    icon = {},
                    modifier = Modifier,
                    selected = true,
            )
        }
    }
}