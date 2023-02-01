package ly.youcan.myapplication.repostory

import androidx.lifecycle.MutableLiveData
import ly.youcan.myapplication.model.Person
import java.util.Calendar

class CalculaterAgeRepostoryImpl():CalculaterAgeRepostory {
    override fun calculaterYourAge(name: String, age: String): MutableLiveData<Person>{
        val infoMutablivedata=MutableLiveData<Person>()
        val currentYear=Calendar.getInstance().get(Calendar.YEAR)
        val yourAge = currentYear-age.toInt()
        val person = Person(name,yourAge)
        infoMutablivedata.postValue(person)
        return infoMutablivedata
    }

}