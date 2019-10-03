package com.insight.mvp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

class EmptyMainActivity : AppCompatActivity() {

    private val LOGIN_ACTIVITY = 13

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityIntent: Intent

        val isLoggedIn = false

        // go straight to main if a token is stored
        if (isLoggedIn) {
            activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        } else {
            activityIntent = Intent(this, LoginActivity::class.java)
            startActivityForResult(activityIntent, LOGIN_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // Check which request we're responding to
        if (requestCode == LOGIN_ACTIVITY) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                // The user logged in
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}
