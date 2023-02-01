package ly.youcan.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import ly.youcan.myapplication.viewmodel.CalculaterAgeViewModel

class MainCalcAgeActivity : AppCompatActivity() {

    lateinit var textname:TextView
    lateinit var editName:EditText
    lateinit var editAge:EditText
    lateinit var btnsubmit:Button

    private val calculaterAgeViewModel :CalculaterAgeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_calc_age)

        textname=findViewById(R.id.textname)
        editName=findViewById(R.id.editName)
        editAge=findViewById(R.id.editAge)
        btnsubmit=findViewById(R.id.btnsubmit)


        btnsubmit.setOnClickListener(){
            val name = editName.text.toString()
            val age = editAge.text.toString()
            calculaterAgeViewModel.calulateAge(name,age).observe(this){
                person ->
                textname.text="${person.name} your age ${person.age}"
            }
        }
    }
}