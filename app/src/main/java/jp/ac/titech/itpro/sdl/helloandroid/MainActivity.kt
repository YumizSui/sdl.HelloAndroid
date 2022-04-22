package jp.ac.titech.itpro.sdl.helloandroid

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var outputView: TextView
    private lateinit var inputName: EditText
    private val KEY_NAME = "MainActivity.name"
    private val name: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        outputView = findViewById(R.id.output_view)
        inputName = findViewById(R.id.input_name)
        findViewById<Button>(R.id.ok_button).setOnClickListener {
            greet()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
        greet()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_NAME, name)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val name = savedInstanceState.getString(KEY_NAME)
        outputView.text = name
        greet()
    }

    private fun greet() {
        val name = inputName.text.toString().trim { it <= ' ' }
        if (name.isNotEmpty()) {
            outputView.text = getString(R.string.output_view_format, name)
        }
    }
}