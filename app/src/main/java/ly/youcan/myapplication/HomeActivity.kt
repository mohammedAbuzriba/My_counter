package ly.youcan.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ly.youcan.myapplication.view.ShapeActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var countapp:Button
    private lateinit var calcapp:Button
    private lateinit var cthraedapp:Button
    private lateinit var shapeapp:Button
    private lateinit var logout:Button
    private lateinit var wellcom:TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()

        val data:String = intent.getStringExtra("name").toString()
        wellcom.text=wellcom.text.toString()+"\n"+data
        countapp.setOnClickListener {
            startActivity(Intent(this,Main2Activity::class.java))
        }
        calcapp.setOnClickListener {
            startActivity(Intent(this,MainCalcAgeActivity::class.java))
        }
        cthraedapp.setOnClickListener {
            startActivity(Intent(this,MainThreadActivity::class.java))
        }
        shapeapp.setOnClickListener {
            startActivity(Intent(this,ShapeActivity::class.java))
        }
        logout.setOnClickListener {
            startActivity(Intent(this,loginActivity::class.java))
        }


    }
    fun init(){
        countapp=findViewById(R.id.countapp)
        calcapp=findViewById(R.id.calcapp)
        cthraedapp=findViewById(R.id.cthraedapp)
        shapeapp=findViewById(R.id.shapeapp)
        logout=findViewById(R.id.logout)
        wellcom=findViewById(R.id.wellcom)
    }
}