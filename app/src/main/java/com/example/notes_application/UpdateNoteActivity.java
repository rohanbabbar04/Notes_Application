package com.example.notes_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class UpdateNoteActivity extends AppCompatActivity {

    private EditText editTextDescription;
    private EditText editTextTitle;
    private Button cancelButton;
    private Button saveButton;
    private int noteId;
    private String existingTitle;
    private String existingDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Edit Item");
        setContentView(R.layout.activity_update_note);
        editTextDescription = findViewById(R.id.editTextDescription2);
        editTextTitle = findViewById(R.id.editTextTitle2);
        cancelButton = findViewById(R.id.buttonCancel2);
        saveButton = findViewById(R.id.buttonSave);
        existingTitle = editTextTitle.getText().toString();
        existingDescription = editTextDescription.getText().toString();

        getNote();

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString();
                String description = editTextDescription.getText().toString();
                if (title.isEmpty() && description.isEmpty()) {
                    Toast.makeText(UpdateNoteActivity.this,"Add Title and Description",Toast.LENGTH_SHORT).show();
                }else if (title.isEmpty()) {
                    Toast.makeText(UpdateNoteActivity.this,"Add Title",Toast.LENGTH_SHORT).show();
                }else if (description.isEmpty()) {
                    Toast.makeText(UpdateNoteActivity.this,"Add Description",Toast.LENGTH_SHORT).show();
                }
                updateNote();
            }
        });
    }

    public void updateNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        if (description.isEmpty() && title.isEmpty()) {
            Toast.makeText(UpdateNoteActivity.this,"Add Title and Description",Toast.LENGTH_SHORT).show();
        } else if (description.isEmpty()) {
            Toast.makeText(UpdateNoteActivity.this,"Add Description",Toast.LENGTH_SHORT).show();
        } else if (title.isEmpty()) {
            Toast.makeText(UpdateNoteActivity.this,"Add Title",Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent();
        intent.putExtra("lastTitle",title);
        intent.putExtra("lastDescription",description);
        if (noteId != -1) {
            intent.putExtra("lastId",noteId);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void getNote() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        noteId = intent.getIntExtra("id",-1);
        editTextTitle.setText(title);
        editTextDescription.setText(description);
    }


}