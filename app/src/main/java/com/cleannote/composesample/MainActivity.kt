package com.cleannote.composesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material.Surface
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import com.cleannote.composesample.compose.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = (0..100).map { "$it number" }
        setContent {
            Surface(color = colorResource(R.color.app_bg)) {
                ListView(list)
            }
        }
    }
}