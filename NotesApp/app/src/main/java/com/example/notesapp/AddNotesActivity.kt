package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.realm.Realm
import java.lang.Exception

class AddNotesActivity : AppCompatActivity() {

    private lateinit var title: EditText
    private lateinit var description: EditText
    private lateinit var saveNotesBtn: Button
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        // init views

        realm = Realm.getDefaultInstance()
        title = findViewById(R.id.titleEditText)
        description = findViewById(R.id.descriptionEditText)
        saveNotesBtn = findViewById(R.id.saveNotesButton)

        // onclick Listener
        saveNotesBtn.setOnClickListener{
            addNotesToDB()
        }
    }

    private fun addNotesToDB() {
        try {

            // Auto Increment ID

            realm.beginTransaction()

            val currentIdNumber:Number? = realm.where(Notes::class.java).max("id")
            val nextID:Int

            nextID = if(currentIdNumber == null) {
                1
            } else  {
                currentIdNumber.toInt() + 1
            }


            val notes = Notes()
            notes.title = title.text.toString()
            notes.description = description.text.toString()
            notes.id = nextID

            // Copy this transaction & commit
            realm.copyToRealmOrUpdate(notes)
            realm.commitTransaction()

            Toast.makeText(this, "Notes added successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()


        } catch (e:Exception) {
            Toast.makeText(this, "Failed $e", Toast.LENGTH_SHORT).show()
        }
    }
}