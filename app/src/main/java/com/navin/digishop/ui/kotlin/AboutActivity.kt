package com.navin.digishop.ui.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.navin.digishop.R
import com.navin.digishop.utils.ApplicationManager
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        var s : String = ""


        btn_call.setOnClickListener{

            Toast.makeText(applicationContext,"hi", Toast.LENGTH_LONG).show()

        }


        val a : Int = ApplicationManager.getAndroidApi()


        val apps : ApplicationManager = ApplicationManager()

        var os  = apps.deviceName;



        bottom_navigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_home_black_24dp))
        bottom_navigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_list_black_24dp))
        bottom_navigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_person_black_24dp))


        bottom_navigation.show(1)


    }
}
