package cookie.clicker.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import cookie.clicker.R

class Icons {
    companion object {
        @Composable
        fun cookie() = painterResource(Ids.cookieId)
        
        @Composable
        fun eaten_cookie() = painterResource(Ids.eaten_cookieId)
    }
    
    class Ids {
        companion object {
            val cookieId = R.drawable.ic_cookie
            val eaten_cookieId = R.drawable.ic_cookie_eaten
        }
    }
}