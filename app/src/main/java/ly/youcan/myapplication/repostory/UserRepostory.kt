package ly.youcan.myapplication.repostory

import androidx.lifecycle.MutableLiveData
import ly.youcan.myapplication.model.User
import ly.youcan.myapplication.resurce.Resorce

interface UserRepostory {
    fun loginUser(user: User,userlist:MutableList<User>): MutableLiveData<Resorce>
    fun signUp(user: User,userlist:MutableList<User>): MutableLiveData<Resorce>
}