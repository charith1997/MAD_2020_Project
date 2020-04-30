package com.example.mad_2020_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FeedbackHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "feedbackDB";
    private static final String TABLE_NAME = "feedbackDB";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String COMMENT = "comment";

    public FeedbackHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE
        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME + " TEXT,"
                + EMAIL + " TEXT,"
                + COMMENT + " TEXT" +
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

    public void addFeedback(Feedback feedback){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME,feedback.getName());
        contentValues.put(EMAIL,feedback.getEmail());
        contentValues.put(COMMENT,feedback.getComment());

        //  Save to Table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        // Close Database
        sqLiteDatabase.close();
    }

    public List<Feedback> getAllFeedbacks(){
        List<Feedback> feedbacks = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do{
                Feedback feedback = new Feedback();
                feedback.setId(cursor.getInt(0));
                feedback.setName(cursor.getString(1));
                feedback.setEmail(cursor.getString(2));
                feedback.setComment(cursor.getString(3));

                feedbacks.add(feedback);
            } while (cursor.moveToNext());
        }

        return feedbacks;
    }

    public void deleteFeedback(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }

    public Feedback getSingleFeedback(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,NAME,EMAIL,COMMENT},ID + "= ?",new String[]{String.valueOf(id)},null,null,null);

        Feedback feedback;
        if (cursor != null){
                cursor.moveToFirst();
            feedback = new Feedback(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
            return feedback;
        }
        return null;
    }

    public int updateSingleFeedback(Feedback feedback){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME,feedback.getName());
        contentValues.put(EMAIL,feedback.getEmail());
        contentValues.put(COMMENT,feedback.getComment());

        int status = db.update(TABLE_NAME,contentValues,ID +" =?",new String[]{String.valueOf(feedback.getId())});

        db.close();

        return status;
    }
}
