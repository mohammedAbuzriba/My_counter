package ly.youcan.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ly.youcan.myapplication.model.User
import ly.youcan.myapplication.resurce.Resorce
import ly.youcan.myapplication.viewmodel.UserLoginViewModel
var userlistpublic= mutableListOf<User>()
class loginActivity : AppCompatActivity() ,TextWatcher{
    private val userLogenViewModel : UserLoginViewModel by viewModels()
    private lateinit var btnlogin:Button
    private lateinit var sign:Button
    private lateinit var txterror:TextView
    private lateinit var emoge:TextView
    private lateinit var progressBar:ProgressBar
    private lateinit var txtuser :EditText
    private lateinit var txtpass :EditText
    private lateinit var username:String
    private lateinit var password:String
    private var keyalertDialog:Boolean=false
    var userlist= mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()

        txtuser.addTextChangedListener(this)
        txtpass.addTextChangedListener(this)

        emoge.setOnClickListener{
            keyalertDialog=!keyalertDialog
            Toast.makeText(applicationContext," alertDialog ${keyalertDialog.toString()}",Toast.LENGTH_SHORT).show()

        }


        btnlogin.setOnClickListener{



            txterror.text = ""
            emoge.text="🔑"
            progressBar.isVisible=true
            username=txtuser.text.toString()
            password=txtpass.text.toString()

            var login= Observer<Resorce> {
                when(it){
                    is Resorce.Successfully->{

                        val i =Intent(this, HomeActivity::class.java)
                        i.putExtra("name",username)
                        GlobalScope.launch (Dispatchers.Main) {
                            if (keyalertDialog) {
                                alertDialog2()
                                delay(3000)
                            }
                            else
                                delay(800)
                            txtuser.text.clear()
                            txtpass.text.clear()
                            emoge.text="🔓"
                            delay(400)

                            startActivity(i)
                            progressBar.isVisible=false
                        }

                    }
                    is Resorce.Error ->{

                        GlobalScope.launch (Dispatchers.Main) {

                            delay(1000)
                            if (keyalertDialog)
                                alertDialog()
                            txterror.text = it.message
                            progressBar.isVisible=false
                            txtuser.text.clear()
                            txtpass.text.clear()
                            emoge.text="😜"
                        }

                    }


//                if (it.isActive){
//                    startActivity(Intent(this, Main2Activity::class.java))
//                } else{
//                    GlobalScope.launch (Dispatchers.Main) {
//                        delay(1000)
//                        txterror.text = it.username.toString()
//                        progressBar.isVisible=false
//
//                        emoge.text="😜"
//                    }
//                }

                }

            }
            userLogenViewModel.login(User(username,password),userlist).observe(this,login)



        }

        sign.setOnClickListener{

            username=txtuser.text.toString()
            password=txtpass.text.toString()
            userLogenViewModel.signUp(User(username,password),userlist).observe(this){
                    when(it){
                        is Resorce.Successfully->{
                            userlist=it.userlist
                            val i =Intent(this, HomeActivity::class.java)
                            i.putExtra("name",username)
                            GlobalScope.launch (Dispatchers.Main) {
                                if (keyalertDialog) {
                                    alertDialog2()
                                    delay(3000)
                                }
                                else
                                    delay(800)
                                txtuser.text.clear()
                                txtpass.text.clear()
                                emoge.text="🔓"
                                delay(400)

                                startActivity(i)
                                progressBar.isVisible=false
                            }

                        }
                        is Resorce.Error ->{

                            GlobalScope.launch (Dispatchers.Main) {

                                delay(1000)
                                if (keyalertDialog)
                                    alertDialog()
                                txterror.text = it.message
                                progressBar.isVisible=false
                                txtuser.text.clear()
                                txtpass.text.clear()
                                emoge.text="😜"
                            }

                        }


//                if (it.isActive){
//                    startActivity(Intent(this, Main2Activity::class.java))
//                } else{
//                    GlobalScope.launch (Dispatchers.Main) {
//                        delay(1000)
//                        txterror.text = it.username.toString()
//                        progressBar.isVisible=false
//
//                        emoge.text="😜"
//                    }
//                }

                    }

                }






        }

    }

    fun init(){
        btnlogin=findViewById(R.id.btnlogin)
        sign=findViewById(R.id.sign)
        txtuser =findViewById(R.id.txtuser)
        txtpass =findViewById(R.id.txtpass)
        txterror =findViewById(R.id.txterror)
        emoge =findViewById(R.id.emoge)
        progressBar =findViewById(R.id.progressBar)


    }


    fun alertDialog(){
        val alertBuilder=AlertDialog.Builder(this)
        val inf=layoutInflater
        val view=inf.inflate(R.layout.test,null)
        val txt=view.findViewById<TextView>(R.id.textView7)
        txt.text=""
        alertBuilder.setView(view)
        alertBuilder.setView(view)
        alertBuilder.setTitle("username or password error")

        val alertDialog=alertBuilder.create()
        alertDialog.show()
        val gs = GlobalScope.launch (Dispatchers.Main) {
            delay(2000)
            //alertDialog.dismiss()
        }
        gs.start()

        val btn=view.findViewById<Button>(R.id.button3)
        btn.setOnClickListener {
            alertDialog.dismiss()
            gs.cancel()
        }
    }
    fun alertDialog2(){
        val alertBuilder=AlertDialog.Builder(this)
        val inf=layoutInflater
        val view=inf.inflate(R.layout.test,null)
        val btn=view.findViewById<Button>(R.id.button3)
        val txt=view.findViewById<TextView>(R.id.textView7)
        txt.text=""
        alertBuilder.setView(view)
        alertBuilder.setTitle("loading ...")

        val alertDialog=alertBuilder.create()
        alertDialog.show()
        GlobalScope.launch (Dispatchers.Main) {

            val anim = AlphaAnimation(1.0f, 0.0f)
            anim.duration = 900
            anim.repeatCount = 1
            anim.repeatMode = Animation.REVERSE
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationEnd(animation: Animation?) {
                    txt.text="🔓"
                }
                override fun onAnimationStart(animation: Animation?) {
                    txt.text="🔑"
                }
                override fun onAnimationRepeat(animation: Animation?) {

                    txt.text="🔒"
                }
            })
            txt.startAnimation(anim)
            delay(2000)

            //alertDialog.dismiss()
        }



        //alertDialog.dismiss()
        btn.setOnClickListener {

            alertDialog.dismiss()
        }
    }
    fun animation(txt:TextView){
        val anim = AlphaAnimation(1.0f, 0.0f)
        anim.duration = 600
        anim.repeatCount = 1
        anim.repeatMode = Animation.REVERSE
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation?) {}
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationRepeat(animation: Animation?) {}
        })
        txt.startAnimation(anim)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val user = txtuser.text.toString()
        val pass = txtpass.text.toString()

        btnlogin.isEnabled=user.trim().isNotEmpty() && pass.trim().isNotEmpty()





        if(user.trim().isNotEmpty())
            emoge.text="🔒"
        if(pass.trim().isNotEmpty())
            emoge.text="🔐"

        if(user.trim().isEmpty() && pass.trim().isEmpty())
            emoge.text="😎"



//        if(user.trim().isNotEmpty() && pass.trim().isNotEmpty())
//            emoge.text="😍"

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun afterTextChanged(s: Editable?) {

    }
}