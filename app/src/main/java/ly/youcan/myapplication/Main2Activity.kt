package ly.youcan.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import ly.youcan.myapplication.CounterPage.CounterViewModel
import ly.youcan.myapplication.model.Count

class Main2Activity : AppCompatActivity() {
    //private val vmcount:CounterViewModel by viewModels()
    private val vmcountobj:CounterViewModel by viewModels()
    private lateinit var btnp:Button
    private lateinit var btnm:Button
    private lateinit var btnr:Button
    private lateinit var txtv:TextView
    private lateinit var textView4:TextView
    private lateinit var txtprime:TextView
    private lateinit var txtevenodd:TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnp=findViewById(R.id.button__)
        btnm=findViewById(R.id.button_)
        btnr=findViewById(R.id.button0)
        txtv=findViewById(R.id.textView3)
        txtprime=findViewById(R.id.textView5)
        textView4=findViewById(R.id.textView4)
        txtevenodd=findViewById(R.id.textView2)
        textView4.text="(✿◡‿◡)"

//        var counterob=Observer<Int> {
//            newnumber -> txtv.text=newnumber.toString()
//        }
//        var counteralert=Observer<Boolean> {
//            newnumber2 -> txtalert.text=newnumber2.toString()
//        }

//        vmcount.counterState.observe(this,Observer<Int> {
//                newnumber -> txtv.text=newnumber.toString()
//        })
//        vmcount.counterState2.observe(this,counteralert)


        vmcountobj.counterstateobj.observe(this,Observer<Count> {
            txtv.text=it.count.toString()
            txtprime.text= "is prime ${it.countPrime.toString()}"
            txtevenodd.text= "is ${it.countEven.toString()}"
            textView4.text= "${it.iamok.toString()}"
        })

        btnm.setOnClickListener(){
            vmcountobj.decrement()
            vmcountobj.prime()
            vmcountobj.EvenOod()
            vmcountobj.iamok()
        }
        btnp.setOnClickListener(){
            vmcountobj.increment()
            vmcountobj.prime()
            vmcountobj.EvenOod()
            vmcountobj.iamok()
        }
        btnr.setOnClickListener(){
            vmcountobj.reset()
            vmcountobj.prime()
            vmcountobj.EvenOod()
            vmcountobj.iamok()
        }
    }
}