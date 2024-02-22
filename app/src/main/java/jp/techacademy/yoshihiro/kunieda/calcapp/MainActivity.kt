package jp.techacademy.yoshihiro.kunieda.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.util.Log
import android.view.View
import android.widget.Button
//import androidx.lifecycle.ReportFragment.Companion.reportFragment
import jp.techacademy.yoshihiro.kunieda.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)

        findViewById<Button>(R.id.button1)
        findViewById<Button>(R.id.button2)
        findViewById<Button>(R.id.button3)
        findViewById<Button>(R.id.button4)

        }

    override fun onClick(v: View?) {
    //    Log.d("VALUE1",binding.editText1.text.toString())
        val intent = Intent(this, SecondActivity::class.java)
    //    intent.putExtra("VALUE1",binding.editText1.toString())
    //    intent.putExtra("VALUE2",binding.editText1.toString())

        val value01 = binding.editText1.text.toString()
        val value02 = binding.editText2.text.toString()

        val value1 = value01.toDoubleOrNull()
        val value2 = value02.toDoubleOrNull()

        var cal:Double? = 0.0
        var error = "計算完了"

        if (value1 == null){
        //    Log.d("ERROR","Val1はnull")
            error = "入力エラー"
        }else if (value2 == null) {
        //    Log.d("ERROR","Val２はnull")
            error = "入力エラー"
        }else{
            if (v?.id == R.id.button1) {
                cal = value1 + value2
            } else if (v?.id == R.id.button2) {
                cal = value1 - value2
            } else if (v?.id == R.id.button3) {
                cal = value1 * value2
            } else if (v?.id == R.id.button4) {
                cal = value1 / value2
            }
            else{
                cal = 0.0
            }
        }

    //    else{
    //        Log.d("ERROR","IDミス".toString())
    //    }

    //  Log.d("ERROR",cal.toString())

        intent.putExtra("CAL",cal.toString().toDouble())
        intent.putExtra("ERROR",error)

    //    intent.putExtra("VALUE1",binding.editText1.text.toString().toDouble())
    //    intent.putExtra("VALUE2",binding.editText2.text.toString().toDouble())

        startActivity(intent)
    }
}