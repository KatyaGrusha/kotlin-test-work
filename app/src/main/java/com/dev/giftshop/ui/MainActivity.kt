package com.dev.giftshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.Toast
import androidx.navigation.Navigation
import com.dev.giftshop.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false
    private var _toast: Toast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        val navController = Navigation.findNavController(this, R.id.fragmentNavHost)
        if(!navController.popBackStack()){
            if (doubleBackToExitPressedOnce) {
                _toast?.cancel()
                super.onBackPressed()
                return
            }

            this.doubleBackToExitPressedOnce = true
            backPressed()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                doubleBackToExitPressedOnce = false
            }, 2000)
        }

    }
    private fun backPressed() {
        _toast = Toast.makeText(
            this.baseContext,
            R.string.back_pressed_text,
            Toast.LENGTH_SHORT
        )
        _toast?.setGravity(Gravity.CENTER, 0, 0)
        _toast?.show()
    }
}