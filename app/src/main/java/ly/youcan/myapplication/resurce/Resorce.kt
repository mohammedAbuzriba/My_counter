package ly.youcan.myapplication.resurce

import ly.youcan.myapplication.model.User

sealed class Resorce{
    object Loading
    data class Successfully(var data:String,var userlist:MutableList<User>):Resorce()
    data class Error(var message: String):Resorce()
}
