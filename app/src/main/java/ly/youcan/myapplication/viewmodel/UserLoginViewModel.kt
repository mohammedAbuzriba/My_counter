package ly.youcan.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ly.youcan.myapplication.model.User
import ly.youcan.myapplication.repostory.UserRepostory
import ly.youcan.myapplication.repostory.UserRepostoryImpl
import ly.youcan.myapplication.resurce.Resorce

class UserLoginViewModel:ViewModel(){
    val userloginRepo:UserRepostory=UserRepostoryImpl()
    fun login(user:User,userlist:MutableList<User>): MutableLiveData<Resorce> {
        return userloginRepo.loginUser(user,userlist)
    }
    fun signUp(user:User,userlist:MutableList<User>): MutableLiveData<Resorce> {
        return userloginRepo.signUp(user,userlist)
    }
}