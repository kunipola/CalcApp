package jp.techacademy.yoshihiro.kunieda.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.techacademy.yoshihiro.kunieda.calcapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    //    val value1:Double = intent.getDoubleExtra("VALUE1", 0.0)
    //    val value2:Double = intent.getDoubleExtra("VALUE2", 0.0)
        val answer:Double = intent.getDoubleExtra("CAL", 0.0)
        val Error = intent.getStringExtra("ERROR")


        binding.textView1.text = answer.toString()
        binding.textView2.text = Error.toString()
    //    binding.textView.text = "${value3 - value2}"
    //    binding.textView.text = "${value1 * value2}"
    //    binding.textView.text = "${value1 / value2}"
    }
}