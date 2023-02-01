package ly.youcan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainThreadActivity : AppCompatActivity() {
    private lateinit var count:TextView
    private lateinit var btnstart:Button
    private lateinit var btnstop :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainthread)
        init()
        var key:Boolean=false
        var GS :Job
        btnstart.setOnClickListener(){
            key=false


             GS= GlobalScope.launch (Dispatchers.Main) {
                for (i in 0..100000){
                    delay(600)
                    if (!key){


                            count.text=i.toString()
                    }else{
                        break
                    }

                }

            }
            GS.start()


        }


        btnstop.setOnClickListener(){

            key=true
        }
    }

    fun init(){
        count=findViewById(R.id.count)
        btnstart=findViewById(R.id.btnstart)
        btnstop=findViewById(R.id.btnstop)
    }
}