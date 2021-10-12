package com.example.notes_application;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.jetbrains.annotations.NotNull;

@Database(entities = Note.class,version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;
    public abstract NoteDao noteDao();

    public synchronized static NoteDatabase getInstance(Context context) {
        instance = Room.databaseBuilder(context,NoteDatabase.class,"note_database")
                .fallbackToDestructiveMigration()
                .build();

        return instance;
    }
}
