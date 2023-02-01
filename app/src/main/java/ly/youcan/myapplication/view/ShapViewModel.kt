package ly.youcan.myapplication.view

import androidx.lifecycle.MutableLiveData
import ly.youcan.myapplication.model.Count
import ly.youcan.myapplication.model.Shape

class ShapViewModel {
    var shape= Shape(0,"","")
    var shapestate= MutableLiveData<Shape>(shape)

    fun shape1(){
        var n: Int
        n=10
        for (i in 1..n) {
            for (j in 1..i) {
                shape.shapStr=shape.shapStr+" ${shape.shapeChar} "
            }
            shape.shapStr=shape.shapStr.toString()+"\n"
        }
    }
    fun shape2(){
        var n: Int
        n=10

        for (i in 1..n) {
            for (j in 1..n) {
                if (i <= (n / 2) && j > i && j <= n - i || i > n / 2 && j < i && j > n - i + 1) {
                    shape.shapStr=shape.shapStr+" "
                } else {
                    shape.shapStr=shape.shapStr+" ${shape.shapeChar} "
                }
            }
            shape.shapStr=shape.shapStr.toString()+"\n"
        }

    }
    fun shape3(){
        var n: Int
        n=10

        for (i in 1..n) {
            for (k in 1 until i) {
                shape.shapStr=shape.shapStr+" "
            }
            shape.shapStr=shape.shapStr+" ${shape.shapeChar} "
            for (j in 1..n * 2 - i * 2) {
                shape.shapStr=shape.shapStr+" ${shape.shapeChar} "
            }
            shape.shapStr=shape.shapStr.toString()+"\n"
        }

    }
    fun shape4(){
        var n: Int
        n=10

        for (i in 1..n) {
            if (i == 1 || i == n) {
                for (j in 1..n) {
                    shape.shapStr=shape.shapStr+" ${shape.shapeChar} "
                }
            } else {
                shape.shapStr=shape.shapStr+" ${shape.shapeChar} "
                for (k in 1..n - 2) {
                    shape.shapStr=shape.shapStr+" "
                }
                shape.shapStr=shape.shapStr+" ${shape.shapeChar} "
            }
            shape.shapStr=shape.shapStr.toString()+"\n"
        }

    }


}