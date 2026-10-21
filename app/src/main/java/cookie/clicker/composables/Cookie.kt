package cookie.clicker.composables

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ripple
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import cookie.clicker.resources.Icons
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun Cookie() {
    var cookies by rememberSaveable { mutableFloatStateOf(0f) }
    var icon by rememberSaveable { mutableIntStateOf(Icons.Ids.cookieId) }
    val scope = rememberCoroutineScope()
    
    val particles = remember { mutableStateListOf<CookieParticle>() }
    
    Box(contentAlignment = Alignment.Center) {
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
                                        
                                        val canSpawn = 20 - particles.size
                                        val toSpawn = minOf(3, canSpawn)
                                        
                                        repeat(toSpawn) {
                                            particles.add(
                                                    CookieParticle(
                                                            id = System.nanoTime() + it,
                                                            angle = Random.nextFloat() * 2f * Math.PI.toFloat(),
                                                            speed = Random.nextFloat() * 180f + 120f,
                                                            size = Random.nextFloat() * 8f + 14f, // ~14–22 dp (среднее ~18)
                                                            rotationSpeed = Random.nextFloat() * 360f - 180f
                                                    )
                                            )
                                        }
                                        
                                        delay(500.milliseconds)
                                        icon = Icons.Ids.cookieId
                                    }
                                }
                        )
                        .padding(bottom = 32.5.dp)
        )
        
        particles.forEach { particle ->
            key(particle.id) {
                ParticleItem(
                        particle = particle,
                        onFinished = { particles.remove(particle) }
                )
            }
        }
    }
    
    Counter(cookies)
}



@Composable
private fun ParticleItem(
        particle: CookieParticle,
        onFinished: () -> Unit
) {
    val progress = remember { Animatable(0f) }
    val alpha = remember { Animatable(1f) }
    
    LaunchedEffect(particle.id) {
        launch {
            progress.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = 700, easing = LinearEasing)
            )
        }
        launch {
            delay(250.milliseconds)
            alpha.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 450, easing = LinearEasing)
            )
        }
        delay(700.milliseconds)
        onFinished()
    }
    
    val distance = particle.speed * progress.value
    val offsetX = cos(particle.angle) * distance
    val offsetY = sin(particle.angle) * distance
    val rotation = particle.rotationSpeed * progress.value
    
    Image(
            painter = painterResource(Icons.Ids.cookieId),
            contentDescription = null,
            modifier = Modifier
                    .size(particle.size.dp)
                    .offset { IntOffset(offsetX.toInt(), offsetY.toInt()) }
                    .graphicsLayer {
                        this.alpha = alpha.value
                        this.rotationZ = rotation
                        scaleX = 1f - progress.value * 0.4f
                        scaleY = 1f - progress.value * 0.4f
                    }
    )
}