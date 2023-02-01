package ly.youcan.myapplication.model

data class ApiData(val isValed: Boolean =true){
    private var userData= mutableListOf<User>(
        User("mohamed","123",true),
        User("ali","123",false),
        User("sara","123",true),
        User("ahmid","123",false),
        User("m","m",true)
    )
    fun getUserData():MutableList<User>{
        return userData
    }
    fun setUserData(user:User){
        userData.add(user)
    }

}

