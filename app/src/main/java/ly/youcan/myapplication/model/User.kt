package ly.youcan.myapplication.model

data class User(val username:String, val password:String, var isActive:Boolean=false){
//    private var userData = mutableListOf<User>()
//    init {
//        setData()
//    }
//    fun setData(){
//        userData=ApiData().getUserData()
//    }
//    fun getUserData():MutableList<User>{
//        return userData
//    }

}

