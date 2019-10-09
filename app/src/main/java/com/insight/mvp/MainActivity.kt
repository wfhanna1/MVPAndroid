package com.insight.mvp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
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
        initializeData()
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

    private fun initializeData() {

        for (i in 1..15)
        {
            val cardView = MaterialCardView(this, null)

            //set view params
            cardView.radius = 15f
            cardView.maxCardElevation = 30f
            cardView.setContentPadding(50, 50, 50, 50)
            cardView.setPadding(50, 50, 50, 50)
            cardView.setCardBackgroundColor(Color.MAGENTA)
            cardView.layoutParams
            cardView.isClickable = true
            cardView.strokeColor = Color.BLACK
            cardView.strokeWidth = 2


            //set child elements in view
            val textview =  TextView(this)
            textview.text = "CardView Programmatically $i"
            textview.setTextColor(Color.WHITE)
            textview.gravity = Gravity.CENTER
            cardView.addView(textview)

            //add new view to layout coordinator
            linearLayout.addView(cardView)

            val marginParams = cardView.layoutParams as ViewGroup.MarginLayoutParams
            marginParams.bottomMargin = 15
            marginParams.leftMargin = 15
            marginParams.rightMargin = 15
            marginParams.topMargin = 15
            marginParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            marginParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu_primary, menu)
        return true
    }
}
