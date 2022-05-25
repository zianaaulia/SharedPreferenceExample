package zianaaulia.polbeng.ac.id.sharedpreferencesexample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filename = "$packageName TESTFILE"
        val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)
        btnsave.setOnClickListener {
            val editor = pref.edit()
            editor.putString("lastname", txtlastname.text.toString())
            editor.putString("firstname", txtfirstname.text.toString())
            editor.apply()
            Toast.makeText(this, "Saved data", Toast.LENGTH_LONG).show()
        }
        btnload.setOnClickListener {
            val mlastname = pref.getString("lastname", "")
            val mfirstname = pref.getString("firstname", "")
            val moutput = "$mfirstname $mlastname"
            txtoutput.text = moutput
        }
        btnSecondActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        txtfirstname.setText("")
        txtlastname.setText("")
        txtfirstname.setHint("first name")
        txtlastname.setHint("last name")
        txtoutput.setText("")
    }
}