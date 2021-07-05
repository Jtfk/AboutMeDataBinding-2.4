package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Jtfk")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.nicknameEdit.requestFocus()

        binding.btnDone.setOnClickListener() {

            binding.apply {
                myName?.nickname = nicknameEdit.text.toString()
                invalidateAll()
                nicknameEdit.visibility = View.GONE
                btnDone.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE
            }

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }

        binding.nicknameText.setOnClickListener() {
            binding.nicknameEdit.visibility = View.VISIBLE
            binding.btnDone.visibility = View.VISIBLE
            binding.nicknameText.visibility = View.GONE
            binding.nicknameEdit.requestFocus()
            binding.nicknameEdit.setSelection(binding.nicknameText.length())

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(binding.nicknameEdit, 0)
        }


    }
}