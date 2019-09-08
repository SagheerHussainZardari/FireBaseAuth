package com.example.firebaseauth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    //First We Need to Have a FirebaseAuth Instance
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createAccount(view: View) {
        showToastS("Please Wait... Creating Account")
        mAuth.createUserWithEmailAndPassword("sagheerhzardari@gmail.com", "12345678")
            .addOnCompleteListener { task ->

                if (task.isSuccessful)
                    showToast("Created Your Account\nEmail: sagheerhzardari@gmail.com\nPass: 12345678")
                else
                    showToast(task.exception.toString())

            }

    }

    fun logIn(view: View) {}
    fun logOut(view: View) {}
    fun verifyEmail(view: View) {}
    fun forgotPassword(view: View) {}

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun showToastS(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
