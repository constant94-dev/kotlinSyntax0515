package com.example.kotlinsyntax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.kotlinsyntax.ui.theme.KotlinSyntaxTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 'suspend' 함수를 사용하기 위해 코루틴을 반영해야 한다
        lifecycleScope.launch {
            myFunc(10) {

            }
        }

        setContent {


        }
    }
}

suspend fun myFunc(
    a: Int,
    callBack: () -> Unit = {}
) {
    println("함수 시작!!!")
    callBack()
    println("함수 끝!!!")
}