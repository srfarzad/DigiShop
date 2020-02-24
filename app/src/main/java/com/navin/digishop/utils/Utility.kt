package com.navin.digishop.utils

import android.content.Context
import android.content.pm.PackageInfo

class Utility {


    fun plus(a: Int, b: Int): Int {

        return a + b

    }

    companion object {


        @Throws(Exception::class)
        fun getVersionName(packageName: String, context: Context): String {
            val pInfo = context.packageManager.getPackageInfo(packageName, 0)
            return pInfo.versionName
        }
    }

}
