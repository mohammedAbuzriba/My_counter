package ly.youcan.myapplication.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ly.youcan.myapplication.R
import ly.youcan.myapplication.viewmodel.UserLoginViewModel

class ShapeActivity : AppCompatActivity() {
    private val userLogenViewModel: UserLoginViewModel by viewModels()

    private lateinit var btnshape: Button
    private lateinit var txtprint: TextView
    private lateinit var txtshape: EditText
    var conter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape)
        init()
        btnshape.setOnClickListener() {
            txtprint.text = ""
            if (conter == 1) {
                shape1()
                conter++
            } else if (conter == 2) {
                shape2()
                conter++
            } else if (conter == 3) {
                shape3()
                conter++
            } else if (conter == 4) {
                shape4()
                conter = 1
            }

        }
    }

    fun init() {
        btnshape = findViewById(R.id.btnshape)
        txtprint = findViewById(R.id.txtprint)
        txtshape = findViewById(R.id.txtshape)
        conter = 1
    }

    fun shape1() {
        var n: Int
        n = 10
        for (i in 1..n) {
            for (j in 1..i) {
                txtprint.text = txtprint.text.toString() + " ${txtshape.text} "
            }
            txtprint.text = txtprint.text.toString() + "\n"
        }
    }

    fun shape2() {
        var n: Int
        n = 10

        for (i in 1..n) {
            for (j in 1..n) {
                if (i <= (n / 2) && j > i && j <= n - i || i > n / 2 && j < i && j > n - i + 1) {
                    txtprint.text = txtprint.text.toString() + " "
                } else {
                    txtprint.text = txtprint.text.toString() + " ${txtshape.text} "
                }
            }
            txtprint.text = txtprint.text.toString() + "\n"
        }

    }

    fun shape3() {
        var n: Int
        n = 10

        for (i in 1..n) {
            for (k in 1 until i) {
                txtprint.text = txtprint.text.toString() + " "
            }
            txtprint.text = txtprint.text.toString() + " ${txtshape.text} "
            for (j in 1..n * 2 - i * 2) {
                txtprint.text = txtprint.text.toString() + " ${txtshape.text} "
            }
            txtprint.text = txtprint.text.toString() + "\n"
        }

    }

    fun shape4() {
        var n: Int
        n = 10

        for (i in 1..n) {
            if (i == 1 || i == n) {
                for (j in 1..n) {
                    txtprint.text = txtprint.text.toString() + " ${txtshape.text} "
                }
            } else {
                txtprint.text = txtprint.text.toString() + " ${txtshape.text} "
                for (k in 1..n - 2) {
                    txtprint.text = txtprint.text.toString() + " "
                }
                txtprint.text = txtprint.text.toString() + " ${txtshape.text} "
            }
            txtprint.text = txtprint.text.toString() + "\n"
        }

    }


}