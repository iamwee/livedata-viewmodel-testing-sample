package com.github.iamwee.livedataunittestingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, MainViewModel.Factory()).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.user.observe(this, Observer {
            textView1.text = it.toString()
        })

        editText1.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                textView1.text = "-"
            } else {
                viewModel.getUser(it.toString())
            }
        }


    }
}
