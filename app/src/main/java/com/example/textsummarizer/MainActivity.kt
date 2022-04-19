package com.example.textsummarizer

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.annotations.SerializedName


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        //Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

//set content view AFTER ABOVE sequence (to avoid crash)
        setContentView(R.layout.activity_main);

//        Floating Action button
        val floadting_Action_Button1=findViewById<FloatingActionButton>(R.id.createAction)

        floadting_Action_Button1.setOnClickListener{
            //In Activity
            Intent(this, ShowResult::class.java).also{
                it.putExtra("key","ENGLISH")
                startActivity(it)
            }
//            intent.putExtra("key", "ENGLISH")
//            startActivity(intent)

        }

        //        Floating Action button
        val floating_Action_Button2=findViewById<FloatingActionButton>(R.id.createAction2)

        floating_Action_Button2.setOnClickListener{
            //In Activity
            Intent(this, ShowResult::class.java).also{
                it.putExtra("key","BANGLA")
                startActivity(it)
            }
//            intent.putExtra("key", "ENGLISH")
//            startActivity(intent)

        }



    }
}



class MUser {

}

data class Json2KtKotlin(

    @SerializedName("summary") var summary: String? = null

)
