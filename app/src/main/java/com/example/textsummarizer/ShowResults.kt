package com.example.textsummarizer

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import org.json.JSONObject

class ShowResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

//set content view AFTER ABOVE sequence (to avoid crash)
        setContentView(R.layout.show_result);

                val backImg = findViewById<ImageButton>(R.id.backButtonMain)
        backImg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val key =intent.getStringExtra("key")
        println("The value came as ---$key")



        val summaryType=findViewById<TextView>(R.id.summarName)
        summaryType.text=key + "Text Summarize: "



        val size=3
        if(key == "ENGLISH") {
            Fuel.post("https://evening-forest-27773.herokuapp.com/summaryEnglish")

                .jsonBody("{ \"text\" : \"Put Text Above and see how the passage is Summarized\",\"size\" : \"$size\" }")
//            .also { println(it) }
                .response { request, response, result ->
//                val jsonObject = json.obj()

                    val data = String(response.data)
                    val text = JSONObject(data)
                    println("The Response is -$data")
                    println("the Value is ---> $text")
                    val aJsonString: String = text.getString("summary")
                    println(aJsonString)
                    val pref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
                    val editor = pref.edit()
                    editor.putString("summary", aJsonString);


                    val textView = findViewById<TextView>(R.id.textView3)
                    textView.setText(aJsonString)

                    val buttonClick = findViewById<Button>(R.id.button2)
                    buttonClick.setOnClickListener {
                        val textArea = findViewById<EditText>(R.id.textEdit3)
                        val n = textArea.getText().toString().replace("\\n", "<br />")
                        val n2 = textArea.text.toString()
//                    println(n)
                        println(n2)
                        val ntext = n2.replace("\\s+".toRegex(), " ")
                        val ntext2 = ntext.replace("\\n".toRegex(), "")
                        val test = JSONObject("{ \"text\" : \"$ntext2\" }")
                        println("the jsonObject is:")
                        println(test)
//                    val intent: Intent = intent
//                    val key = intent.getStringExtra("key")
//                    val key =intent.getStringExtra("key")
//                    println("The value came as ---$key")

                        Fuel.post("https://evening-forest-27773.herokuapp.com/summaryEnglish")
                            .jsonBody("{ \"text\" : \"$ntext\" , \"size\" : \"$size\" }")
//            .also { println(it) }
                            .response { request, response, result ->
//                val jsonObject = json.obj()

                                val data = String(response.data)
                                val text = JSONObject(data)
                                println("The Response is -$data")
                                println("the Value is ---> $text")
                                val aJsonString: String = text.getString("summary")
                                println(aJsonString)
                                val pref =
                                    applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
                                val editor = pref.edit()
                                editor.putString("summary", aJsonString);


                                val textView = findViewById<TextView>(R.id.textView3)
                                textView.setText(aJsonString)
                            }

//                    val intent = Intent(this, ShowResult::class.java)
//                    startActivity(intent)
                    }
                }
        }else{

            Fuel.post("https://evening-forest-27773.herokuapp.com/summaryBangla")

                .jsonBody("{ \"text\" : \"Put Text Above and see how the passage is Summarized\",\"size\" : \"$size\" }")
//            .also { println(it) }
                .response { request, response, result ->
//                val jsonObject = json.obj()

                    val data = String(response.data)
                    val text = JSONObject(data)
                    println("The Response is -$data")
                    println("the Value is ---> $text")
                    val aJsonString: String = text.getString("summary")
                    println(aJsonString)
                    val pref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
                    val editor = pref.edit()
                    editor.putString("summary", aJsonString);


                    val textView = findViewById<TextView>(R.id.textView3)
                    textView.setText(aJsonString)

                    val buttonClick = findViewById<Button>(R.id.button2)
                    buttonClick.setOnClickListener {
                        val textArea = findViewById<EditText>(R.id.textEdit3)
                        val n = textArea.getText().toString().replace("\\n", "<br />")
                        val n2 = textArea.text.toString()
//                    println(n)
                        println(n2)
                        val ntext = n2.replace("\\s+".toRegex(), " ")
                        val ntext2 = ntext.replace("\\n".toRegex(), "")
                        val test = JSONObject("{ \"text\" : \"$ntext2\" }")
                        println("the jsonObject is:")
                        println(test)
//                    val intent: Intent = intent
//                    val key = intent.getStringExtra("key")
//                    val key =intent.getStringExtra("key")
//                    println("The value came as ---$key")

                        Fuel.post("https://evening-forest-27773.herokuapp.com/summaryBangla")
                            .jsonBody("{ \"text\" : \"$ntext\" , \"size\" : \"$size\" }")
//            .also { println(it) }
                            .response { request, response, result ->
//                val jsonObject = json.obj()

                                val data = String(response.data)
                                val text = JSONObject(data)
                                println("The Response is -$data")
                                println("the Value is ---> $text")
                                val aJsonString: String = text.getString("summary")
                                println(aJsonString)
                                val pref =
                                    applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
                                val editor = pref.edit()
                                editor.putString("summary", aJsonString);


                                val textView = findViewById<TextView>(R.id.textView3)
                                textView.setText(aJsonString)
                            }

//                    val intent = Intent(this, ShowResult::class.java)
//                    startActivity(intent)
                    }
                }

        }


    }


}