package ly.youcan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnplass:Button
    private lateinit var btnmaines:Button
    private lateinit var txtView:TextView
    private  var number:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initui()
    }

    fun initui(){
        btnmaines=findViewById(R.id.button2)
        btnplass=findViewById(R.id.button)
        txtView=findViewById(R.id.textView)
        btnplass.setOnClickListener{

            GlobalScope.launch {

                delay(3000L)
                GlobalScope.launch (Dispatchers.Main) {

                    number += 1
                    txtView.text = number.toString()
                }
            }
//            thread.start()
//            txtView.text =thread.isActive.toString()
        }
        btnmaines.setOnClickListener(){

            number-=1
            txtView.text=(number).toString()
//            thread.cancel()
        }
    }



}