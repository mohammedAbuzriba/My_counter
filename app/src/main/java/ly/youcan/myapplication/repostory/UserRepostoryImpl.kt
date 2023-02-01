package ly.youcan.myapplication.repostory

import androidx.lifecycle.MutableLiveData
import ly.youcan.myapplication.model.ApiData
import ly.youcan.myapplication.model.User
import ly.youcan.myapplication.resurce.Resorce

class UserRepostoryImpl():UserRepostory {


    override fun loginUser(user: User,userlist:MutableList<User>): MutableLiveData<Resorce> {

        val infoMutablivedata = MutableLiveData<Resorce>()
        var api = ApiData().getUserData()

        if (userlist.isNotEmpty()){
            api = userlist
        }

        for (i in api) {
            if (i.username==user.username && i.password==user.password ) {
                infoMutablivedata.value= Resorce.Successfully("successfully",api)
                return infoMutablivedata
            }
        }
        infoMutablivedata.value=Resorce.Error("Not found")
        return infoMutablivedata
    }

    override fun signUp(user: User,userlist:MutableList<User>): MutableLiveData<Resorce> {
        val infoMutablivedata = MutableLiveData<Resorce>()
        var api = ApiData()
        var uaerapi=api.getUserData()

        if (userlist.isNotEmpty()){
            uaerapi = userlist
        }
        for (i in uaerapi) {
            if (i.username==user.username && i.password==user.password ) {
                infoMutablivedata.value= Resorce.Error("found same name")
                return infoMutablivedata
            }
        }
        user.isActive=true
        api.setUserData(user)
        infoMutablivedata.value=Resorce.Successfully("successfully",api.getUserData())
        return infoMutablivedata
    }


/*
    override fun loginUser(username: String, password: String): MutableLiveData<Resorce> {

        val user = User(username, password)
        val infoMutablivedata = MutableLiveData<Resorce>()
        val api = ApiData().getUserData()
        for (i in api) {
            if (i.username == username) {
                infoMutablivedata.value= Resorce.Succusfuly("Succusfuly")
                return infoMutablivedata
            }
        }
        infoMutablivedata.value=Resorce.Error("Error")
        return infoMutablivedata
    }

*/


}