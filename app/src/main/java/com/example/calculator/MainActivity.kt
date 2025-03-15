
package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() , View.OnClickListener {
    lateinit var textResult: TextView

    var state: Int = 1 //Nhap so dau tien va so thu hai
    var op: Int = 0 //Theo thu tu cong tru nhan chia
    var op1: Int = 0
    var op2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textResult = findViewById(R.id.textView)

        findViewById<Button>(R.id.zero).setOnClickListener(this)
        findViewById<Button>(R.id.one).setOnClickListener(this)
        findViewById<Button>(R.id.two).setOnClickListener(this)
        findViewById<Button>(R.id.three).setOnClickListener(this)
        findViewById<Button>(R.id.four).setOnClickListener(this)
        findViewById<Button>(R.id.five).setOnClickListener(this)
        findViewById<Button>(R.id.six).setOnClickListener(this)
        findViewById<Button>(R.id.seven).setOnClickListener(this)
        findViewById<Button>(R.id.eight).setOnClickListener(this)
        findViewById<Button>(R.id.nine).setOnClickListener(this)
        findViewById<Button>(R.id.cong).setOnClickListener(this)
        findViewById<Button>(R.id.tru).setOnClickListener(this)
        findViewById<Button>(R.id.nhan).setOnClickListener(this)
        findViewById<Button>(R.id.chia).setOnClickListener(this)
        findViewById<Button>(R.id.bang).setOnClickListener(this)
        findViewById<Button>(R.id.CE).setOnClickListener(this)
        findViewById<Button>(R.id.C).setOnClickListener(this)
        findViewById<Button>(R.id.BS).setOnClickListener(this)
        findViewById<Button>(R.id.dau).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.zero) {
            addDigit(0)
        } else if (id == R.id.one) {
            addDigit(1)
        } else if (id == R.id.two) {
            addDigit(2)
        } else if (id == R.id.three) {
            addDigit(3)
        } else if (id==R.id.four) {
            addDigit(4)
        } else if (id==R.id.five) {
            addDigit(5)
        }else if (id==R.id.six) {
            addDigit(6)
        }else if (id==R.id.seven) {
            addDigit(7)
        }else if (id==R.id.eight) {
            addDigit(8)
        }else if (id==R.id.nine) {
            addDigit(9)
        }
        else if (id == R.id.cong) {
            if(state == 2) Result()
            op = 1
            state = 2
        } else if (id == R.id.tru) {
            if(state == 2) Result()
            op = 2
            state = 2
        }else if (id == R.id.nhan) {
            if(state == 2) Result()
            op = 3
            state = 2
        }else if (id == R.id.chia) {
            if(state == 2) Result()
            op = 4
            state = 2
        }
        else if(id == R.id.CE){
            clearEntry()
        }
        else if(id == R.id.C){
            clear()
        }
        else if(id== R.id.BS){
            backspace()
        }
        else if (id == R.id.bang) {
            Result()
        }
        else if(id == R.id.dau){
            daoDau()
        }
    }

    fun addDigit(c: Int) {
        if (state == 1) {
            op1 = op1 * 10 + c
            textResult.text = "$op1"
        } else {
            op2 = op2 * 10 + c
            textResult.text = "$op2"
        }
    }
    fun clearEntry() {
        if (state == 1) {
            op1 = 0
            textResult.text = "$op1"
        } else {
            op2 = 0
            textResult.text = "$op2"
        }
    }
    fun clear() {
        op1 = 0
        op2 = 0
        state =1
        op = 0
        textResult.text = "$op1"
    }
    fun backspace() {
        if (state == 1) {
            if( op1 >= 10 ) op1 = op1/10
            else op1=0
            textResult.text = "$op1"
        } else {
            if(op2>=10) op2 = op2/10
            else op2=0
            textResult.text = "$op2"
        }
    }
    fun Result(){
        if(op==0) {
            textResult.text = "0"
            return
        }
        var result = 0
        if (op == 1) {
            result = op1 + op2
        } else if (op == 2) {
            result = op1 - op2
        } else if (op == 3) {
            result = op1 * op2
        } else if (op == 4) {
            result = op1 / op2
        }
        textResult.text = "$result"
        state = 1
        op1 = result
        op2 = 0
        op = 0
    }
    fun daoDau(){
        if(state == 1){
            op1 = 0 - op1
            textResult.text = "$op1"
        } else {
            op2 = 0 - op2
            textResult.text = "$op2"
        }
    }
}
