package com.aminography.commonutils.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aminography.commonutils.physicalScreenRectDp
import com.aminography.commonutils.physicalScreenRectPx
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

        println()

        val physicalWidthPx = physicalScreenRectPx.width()
        val physicalHeightPx = physicalScreenRectPx.height()
        println("[PX] physical screen width: $physicalWidthPx , height: $physicalHeightPx")

        val physicalWidthDp = physicalScreenRectDp.width()
        val physicalHeightDp = physicalScreenRectDp.height()
        println("[DP] physical screen width: $physicalWidthDp , height: $physicalHeightDp")
    }
}

