package cookie.clicker.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import cookie.clicker.resources.Colors

@Composable
fun Clicker() {
    Scaffold(
            modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
                modifier = Modifier
                        .fillMaxSize()
                        .background(
                                brush = Brush.linearGradient(
                                        colors = listOf(
                                                Colors.orange1(),
                                                Colors.orange2(),
                                                Colors.orange3(),
                                                Colors.orange4()
                                        ),
                                ),
                                shape = RectangleShape,
                        ),
                contentAlignment = Alignment.Center
        ) {
            Column(
                    modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    horizontalAlignment
                    = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
            ) {
                Cookie()
            }
        }
    }
}