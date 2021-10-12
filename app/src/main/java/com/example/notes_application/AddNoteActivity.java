package com.example.notes_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class AddNoteActivity extends AppCompatActivity {

    private Button buttonCancel;
    private Button buttonOk;
    private EditText editTextTitle;
    private EditText editTextDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Add New Note");
        setContentView(R.layout.activity_add_note);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonOk = findViewById(R.id.buttonOk);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextTitle = findViewById(R.id.editTextTitle);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
                finish();
            }
        });
    }

    public void saveNote() {
        String noteTitle = editTextTitle.getText().toString();
        String noteDescription = editTextDescription.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("noteTitle",noteTitle);
        intent.putExtra("noteDescription",noteDescription);
        setResult(RESULT_OK,intent);
    }
}