package com.example.fcstade.utils

import android.content.Context
import com.example.fcstade.utils.Constants.PREFS_TOKEN_FILE
import com.example.fcstade.utils.Constants.User_Token
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManger @Inject constructor(@ApplicationContext context: Context){
    private var prefs=context.getSharedPreferences(PREFS_TOKEN_FILE, Context.MODE_PRIVATE)

    fun saveToken(token:String){
        val editor = prefs.edit()
        editor.putString(User_Token,token)
        editor.apply()
    }

    fun getToken():String? {
        return prefs.getString(User_Token,null)
    }
}