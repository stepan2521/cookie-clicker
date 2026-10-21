package cookie.clicker.composables

data class CookieParticle(
        val id: Long,
        val angle: Float,
        val speed: Float,
        val size: Float = 28f,
        val rotationSpeed: Float = 0f
)