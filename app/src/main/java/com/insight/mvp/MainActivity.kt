package com.insight.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import io.material.catalog.bottomappbar.BottomAppBarCutCornersTopEdge
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(appbar)
        setupBottomAppBarCutCornersBackground()
    }

    // Use this function to enable cut corners for the BottomAppBar FAB cradle
    // Note: It does NOT respond to increasing/decreasing the FAB cradle margin, rounded corner radius or vertical offset
    // Copied from: https://github.com/material-components/material-components-android/blob/master/catalog/java/io/material/catalog/bottomappbar/BottomAppBarCutCornersTopEdge.java
    private fun setupBottomAppBarCutCornersBackground() {
        val topEdge = BottomAppBarCutCornersTopEdge(
            
            appbar.fabCradleMargin,
            appbar.fabCradleRoundedCornerRadius,
            appbar.cradleVerticalOffset
        )
        val background = appbar.background as MaterialShapeDrawable
        val shapeAppearanceModel = ShapeAppearanceModel.Builder().setTopEdge(topEdge).build()
        background.shapeAppearanceModel = shapeAppearanceModel
        background.invalidateSelf()
    }
}
