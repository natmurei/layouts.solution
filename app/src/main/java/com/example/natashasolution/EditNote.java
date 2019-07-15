package com.example.natashasolution;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.natashasolution.database.DatabaseHelper;
import com.example.natashasolution.database.Note;

public class EditNote extends AppCompatActivity {

    EditText etTitle;
    EditText etNote;
    Button btnAddPhoto;
    Button btnAddVoiceNote;
    Button btnUpdate;
    String title;
    String noteText;
    ImageView img;
    private static final int CAPTURE_IMAGE_RESQUEST_CODE=500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getNoteId();
        etTitle= findViewById(R.id.etTitle);
        etNote = findViewById(R.id.etNote);
        btnAddPhoto=findViewById(R.id.btnAddPhoto);
        btnAddVoiceNote=findViewById(R.id.btnAddVoiceNote);
        btnUpdate= findViewById(R.id.btnUpdate);

        img=findViewById(R.id.img);
        displayNote();





        public void getNoteId(){
            Bundle bundle=getIntent().getExtras();
            if (bundle!=null){
                noteId=bundle.getInt("NOTE-ID",0);

            }

            public void displayNote(){
                DatabaseHelper databaseHelper= new DatabaseHelper(getBaseContext(),"notes",null,1);
                Note note = databaseHelper.getNoteById(noteId);
                tvTitle.setText(note.getTitle());
                tvNoteText.setText(note.getNoteText());
            }
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
