package cookie.clicker.resources

import androidx.annotation.ColorRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import cookie.clicker.R

class Colors {
    companion object {
        @Composable fun orange1() = colorResource(Ids.orange1)
        @Composable fun orange2() = colorResource(Ids.orange2)
        @Composable fun orange3() = colorResource(Ids.orange3)
        @Composable fun orange4() = colorResource(Ids.orange4)
    }
    
    class Ids {
        companion object {
            @ColorRes val orange1 = R.color.orange1
            @ColorRes val orange2= R.color.orange2
            @ColorRes val orange3 = R.color.orange3
            @ColorRes val orange4 = R.color.orange4
            
            @ColorRes val cookie_main = R.color.cookie_main
            @ColorRes val cookie_border = R.color.cookie_border
            @ColorRes val cookie_chocolate = R.color.cookie_chocolate
            
        }
    }
}