package com.example.languagedetect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnFailureListener

import com.google.android.gms.tasks.OnSuccessListener

import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage

import com.google.firebase.ml.naturallanguage.languageid.FirebaseLanguageIdentification
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit.setOnClickListener {
        val languageIdentifier = FirebaseNaturalLanguage.getInstance().languageIdentification
        languageIdentifier.identifyLanguage(input_text.text.toString())
            .addOnSuccessListener { languageCode ->
                if (languageCode !== "und") {
                   detected_language.text = "Language Code => $languageCode"
                } else {
                    Log.i("TAGGGG", "Can't identify language.")
                    detected_language.text = "Can't identify language."
                }
            }
            .addOnFailureListener {
                // Model couldn’t be loaded or other internal error.
                // ...
            }
    }
    }
}