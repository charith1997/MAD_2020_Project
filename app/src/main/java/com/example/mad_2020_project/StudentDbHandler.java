package com.example.mad_2020_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "studentDB";
    private static final String TABLE_NAME = "studentDB";

    private static final String STUDENTID = "id";
    private static final String STUDENTNAME = "username";
    private static final String EMAIL = "email";
    private static final String MOBNUMBER = "mobnumber";
    private static final String PASSWORD = "password";
    private static final String CONPASSWORD = "conpassword";

    public StudentDbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CREATE TABLE
        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + STUDENTID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + STUDENTNAME + " TEXT,"
                + EMAIL + " TEXT,"
                + MOBNUMBER + " TEXT,"
                + PASSWORD + " TEXT,"
                + CONPASSWORD + " TEXT" +
                ");";

        db.execSQL(TABLE_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        // Drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);
        // Create table again
        onCreate(db);
    }

    public void addStudent(Student student){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(STUDENTNAME,student.getStudentName());
        contentValues.put(EMAIL,student.getEmail());
        contentValues.put(MOBNUMBER,student.getMobileNo());
        contentValues.put(PASSWORD,student.getPassword());
        contentValues.put(CONPASSWORD,student.getConfirmPassword());

        //  Save to Table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        // Close Database
        sqLiteDatabase.close();
    }
}
