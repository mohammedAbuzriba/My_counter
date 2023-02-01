package ly.youcan.myapplication.CounterPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ly.youcan.myapplication.model.Count


class CounterViewModel:ViewModel(){

    var coun= Count(0,false,"Even","(✿◡‿◡)")
    var counterstateobj=MutableLiveData<Count>(coun)
    var counterState = MutableLiveData<Int>(0)
    var counterState2 = MutableLiveData<Boolean>(false)
    var isprime=false

    fun increment(){

        //counterState.value=counter

        coun.count+=1
        counterstateobj.value=coun
    }
    fun decrement(){
        //counter--
        //counterState.value=counter
        coun.count-=1
        counterstateobj.value=coun
    }
    fun reset(){
        //counter=0
        //counterState.value=counter

        coun.count=  0
        counterstateobj.value=coun
    }

    fun prime(){

        var flag = false
        for (i in 2..coun.count / 2) {
            // condition for nonprime number
            if (coun.count % i == 0) {
                flag = true
                break
            }
        }

        if (!flag)
            isprime=true
        else
           isprime=false

        //counterState2.value=isprime

        coun.countPrime=isprime
        counterstateobj.value=coun
    }

    fun EvenOod(){

        if (coun.count %2 == 0) {
            coun.countEven="Even"

        }else {
            coun.countEven = "Odd"
        }

        counterstateobj.value=coun
    }

    fun iamok(){
//        if (coun.count>10){
//            coun.iamok="^_^"
//            counterstateobj.value=coun
//        }
//        if (coun.count<5){
//            coun.iamok="-_-"
//            counterstateobj.value=coun
//        }
        if (coun.count==0){
            coun.iamok="(✿◡‿◡)"
        }
        if (coun.count>0){
            coun.iamok="(☞ﾟヮﾟ)☞"
        }
        if (coun.count<0){
            coun.iamok="☜(ﾟヮﾟ☜)"
        }

        counterstateobj.value=coun
    }

}