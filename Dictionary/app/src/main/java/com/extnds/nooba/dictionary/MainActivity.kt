package com.extnds.nooba.dictionary

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.UserDictionary
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resolver = contentResolver
        var cursor : Cursor? = null
        try {

            cursor = resolver.query(UserDictionary.Words.CONTENT_URI,null,null,null,null)
            var s : String = ""
            while (cursor.moveToNext())
            {
                s += cursor.getString(cursor.getColumnIndex("Word")) + "\n" +
                        "id   : " + cursor.getString(cursor.getColumnIndex("_ID")) + "\n" +
                        "Freq : " + cursor.getString(cursor.getColumnIndex("Frequency")) + "\n" +
                        "-------------------------------------------------------------------\n"
            }
            user_dict_words.text = s
        }finally {
            cursor?.close()
        }

    }
}
