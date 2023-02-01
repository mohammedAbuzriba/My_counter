package ly.youcan.myapplication.repostory

import androidx.lifecycle.MutableLiveData
import ly.youcan.myapplication.model.Person

interface CalculaterAgeRepostory {
    fun calculaterYourAge(name:String,age:String): MutableLiveData<Person>
}