package com.example.mad_2020_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "sellerDB";
    private static final String TABLE_NAME = "sellerDB";

    private static final String ID = "id";
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String MOBNUMBER = "mobnumber";
    private static final String VENUE = "venue";
    private static final String NOWORKERS = "noworkers";
    private static final String FROMDATE = "fromdate";
    private static final String TODATE = "todate";
    private static final String PASSWORD = "password";
    private static final String REPASSWORD = "repassword";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CREATE TABLE
        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + USERNAME + " TEXT,"
                + EMAIL + " TEXT,"
                + MOBNUMBER + " TEXT,"
                + VENUE + " TEXT,"
                + NOWORKERS + " TEXT,"
                + FROMDATE + " TEXT,"
                + TODATE + " TEXT,"
                + PASSWORD + " TEXT,"
                + REPASSWORD + " TEXT" +
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

    public void addSeller(Seller seller){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(USERNAME,seller.getUsername());
        contentValues.put(EMAIL,seller.getEmail());
        contentValues.put(MOBNUMBER,seller.getMobileNo());
        contentValues.put(VENUE,seller.getVenue());
        contentValues.put(NOWORKERS,seller.getWorkers());
        contentValues.put(FROMDATE,seller.getDateFrom());
        contentValues.put(TODATE,seller.getDateTo());
        contentValues.put(PASSWORD,seller.getPswd());
        contentValues.put(REPASSWORD,seller.getRePswd());

        //  Save to Table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        // Close Database
        sqLiteDatabase.close();
    }

    public List<Seller> getAllSellers(){
        List<Seller> sellers = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                Seller seller = new Seller();
                seller.setId(cursor.getInt(0));
                seller.setUsername(cursor.getString(1));
                seller.setEmail(cursor.getString(2));
                seller.setMobileNo(cursor.getString(3));
                seller.setVenue(cursor.getString(4));
                seller.setWorkers(cursor.getInt(5));
                seller.setDateFrom(cursor.getString(6));
                seller.setDateTo(cursor.getString(7));
                seller.setPswd(cursor.getString(8));

                sellers.add(seller);
            } while (cursor.moveToNext());
        }

        return sellers;
    }

    public void deleteUser(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }

    public Seller getSingleUser(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,USERNAME,EMAIL,MOBNUMBER,VENUE,NOWORKERS,FROMDATE,TODATE,PASSWORD},ID + "= ?",new String[]{String.valueOf(id)},null,null,null);

        Seller seller;
        if (cursor != null){
                cursor.moveToFirst();
            seller = new Seller(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9)
            );
            return seller;
        }
        return null;
    }

    public int updateSingleView(Seller seller){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(USERNAME,seller.getUsername());
        contentValues.put(EMAIL,seller.getEmail());
        contentValues.put(MOBNUMBER,seller.getMobileNo());
        contentValues.put(VENUE,seller.getVenue());
        contentValues.put(NOWORKERS,seller.getWorkers());
        contentValues.put(FROMDATE,seller.getDateFrom());
        contentValues.put(TODATE,seller.getDateTo());
        contentValues.put(PASSWORD,seller.getPswd());
        contentValues.put(REPASSWORD,seller.getRePswd());

        int status = db.update(TABLE_NAME,contentValues,ID + " =?",new String[]{String.valueOf(seller.getId())});

        db.close();

        return status;
    }
}
