package com.aminography.commonutils.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aminography.commonutils.formatAsFileSize
import com.aminography.commonutils.screenRectDp
import com.aminography.commonutils.screenRectPx
import com.aminography.commonutils.withPersianDigits

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

        println("Numerical 15   becomes: " + 15.withPersianDigits)
        println("Numerical 2.75 becomes: " + 2.75.withPersianDigits)

        println("Textual 470  becomes: " + "470".withPersianDigits)
        println("Textual 3.14 becomes: " + "3.14".withPersianDigits)

        println("0:        " + 0.formatAsFileSize)
        println("170:        " + 170.formatAsFileSize)
        println("14356:      " + 14356.formatAsFileSize)
        println("968542985:  " + 968542985.formatAsFileSize)
        println("8729842496: " + 8729842496.formatAsFileSize)
    }
}

