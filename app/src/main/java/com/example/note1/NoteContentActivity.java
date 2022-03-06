package com.example.note1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class NoteContentActivity extends AppCompatActivity {

    public static void actionStart(Context context){
        Intent intent = new Intent(context,NoteContentActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_content);
    }
}