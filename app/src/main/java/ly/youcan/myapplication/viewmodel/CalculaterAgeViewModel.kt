package ly.youcan.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ly.youcan.myapplication.model.Person
import ly.youcan.myapplication.repostory.CalculaterAgeRepostory
import ly.youcan.myapplication.repostory.CalculaterAgeRepostoryImpl

class CalculaterAgeViewModel:ViewModel(){
    val calculaterAgeRepo:CalculaterAgeRepostory=CalculaterAgeRepostoryImpl()
    fun calulateAge(name:String,age:String): MutableLiveData<Person> {
       var personMutabeliveData= calculaterAgeRepo.calculaterYourAge(name,age)
        return personMutabeliveData
    }
}