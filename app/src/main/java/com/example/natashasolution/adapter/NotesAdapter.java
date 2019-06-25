package com.example.natashasolution.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.natashasolution.R;
import com.example.natashasolution.database.Note;

import java.util.List;

public class NotesAdapter extends ArrayAdapter<Note> {
    public NotesAdapter(@NonNull Context context, int resource, @NonNull List<Note> noteList) {
        super(context, resource, noteList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Note note= getItem(position);
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.note_list_item,parent,false);
        }

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvNoteText = convertView.findViewById(R.id.tvNoteText);
        tvTitle.setText(note.getTitle());
        tvNoteText.setText(note.getNoteText());

        return convertView;
    }
}
