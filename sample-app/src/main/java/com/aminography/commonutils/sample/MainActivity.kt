package com.aminography.commonutils.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aminography.commonutils.screenRectDp
import com.aminography.commonutils.screenRectPx

/**
 * @author aminography
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val widthPx = screenRectPx.width()
        val heightPx = screenRectPx.height()
        println("[PX] screen width: $widthPx , height: $heightPx")

        val widthDp = screenRectDp.width()
        val heightDp = screenRectDp.height()
        println("[DP] screen width: $widthDp , height: $heightDp")
    }
}
