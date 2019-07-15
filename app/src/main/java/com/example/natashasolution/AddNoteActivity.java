package com.example.natashasolution;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.natashasolution.database.DatabaseHelper;
import com.example.natashasolution.database.Note;

public class AddNoteActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etNote;
    Button btnAddPhoto;
    Button btnAddVoiceNote;
    Button btnSave;
    String title;
    String noteText;
    ImageView img;
    private static final int CAPTURE_IMAGE_RESQUEST_CODE=500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        etTitle= findViewById(R.id.etTitle);
        etNote = findViewById(R.id.etNote);
        btnAddPhoto=findViewById(R.id.btnAddPhoto);
        btnAddVoiceNote=findViewById(R.id.btnAddVoiceNote);
        btnSave= findViewById(R.id.btnSave);
        img=findViewById(R.id.img);



        btnAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAPTURE_IMAGE_RESQUEST_CODE);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            title=etTitle.getText().toString();
            noteText=etNote.getText().toString();


            Note note = new Note(title,noteText);
            DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext(),"notes",null,1);
            long rows = databaseHelper.addNote(note);
                Log.d("AddNote","The number of notes"+ rows);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CAPTURE_IMAGE_RESQUEST_CODE && resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            Bitmap bitmap=(Bitmap)bundle.get("data");
            img.setImageBitmap(bitmap);
        }
    }
}
