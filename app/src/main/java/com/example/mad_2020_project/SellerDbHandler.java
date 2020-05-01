package com.example.mad_2020_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

<<<<<<< Updated upstream:app/src/main/java/com/example/mad_2020_project/SellerDbHandler.java
public class SellerDbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "SellerDB";
    private static final String TABLE_NAME = "SellerDB";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PHONENO = "phoneNo";
    private static final String LOCATION = "location";
    private static final String WORKERS = "workers";
    private static final String FROMDATE = "fromDate";
    private static final String TODATE = "toDate";
    private static final String PASSWORD = "password";

    public SellerDbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
=======
class DbHandler extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int VERSION=1;
    public static final String DATABASE_NAME="todo";
    public static final String TABLE_NAME="todo";

    private static final String ID="id";
    private static final String Name="name";
    private static final String Price="price";
    private static final String Started="started";
    private static final String Finished="finished";


    public DbHandler(Context context) {

        super(context, DATABASE_NAME, null, VERSION);
    }

    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
>>>>>>> Stashed changes:app/src/main/java/com/example/mad_2020_project/DbHandler.java
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
<<<<<<< Updated upstream:app/src/main/java/com/example/mad_2020_project/SellerDbHandler.java

        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME + " TEXT,"
                + EMAIL + " TEXT,"
                + PHONENO + " TEXT,"
                + LOCATION + " TEXT,"
                + WORKERS + " TEXT,"
                + FROMDATE + " TEXT,"
                + TODATE + " TEXT,"
                + PASSWORD + " TEXT" +
                ");";

=======
        String TABLE_CREATE_QUERY="CREATE TABLE " + TABLE_NAME + "" +
                "("
                + ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Name + "TEXT,"
                + Price + "String,"
                + Started + "TEXT,"
                + Finished + "TEXT" +
                ");";

            /* CREATE TABLE Dbhandler (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, price STRING
            started TEXT,finished TEXT);
             */

>>>>>>> Stashed changes:app/src/main/java/com/example/mad_2020_project/DbHandler.java
        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String Drop_TABLE_QUERY="DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(Drop_TABLE_QUERY);
        onCreate(db);
    }

    public void additems(ToDo todo) {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(Name, todo.getName());
        contentValues.put(Price, todo.getPrice());

<<<<<<< Updated upstream:app/src/main/java/com/example/mad_2020_project/SellerDbHandler.java
        contentValues.put(NAME,seller.getName());
        contentValues.put(EMAIL,seller.getEmail());
        contentValues.put(PHONENO,seller.getPhoneNo());
        contentValues.put(LOCATION,seller.getLocation());
        contentValues.put(WORKERS,seller.getWorkers());
        contentValues.put(FROMDATE,seller.getFromDate());
        contentValues.put(TODATE,seller.getToDate());
        contentValues.put(PASSWORD,seller.getPassword());
=======
        //save to table
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
>>>>>>> Stashed changes:app/src/main/java/com/example/mad_2020_project/DbHandler.java

        sqLiteDatabase.close();
    }

<<<<<<< Updated upstream:app/src/main/java/com/example/mad_2020_project/SellerDbHandler.java
    public List<Seller> getAllSellers(){
        List<Seller> sellers = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do{
                Seller seller = new Seller();
                seller.setId(cursor.getInt(0));
                seller.setName(cursor.getString(1));
                seller.setEmail(cursor.getString(2));
                seller.setPhoneNo(cursor.getString(3));
                seller.setLocation(cursor.getString(4));
                seller.setWorkers(cursor.getString(5));
                seller.setFromDate(cursor.getString(6));
                seller.setToDate(cursor.getString(7));
                seller.setPassword(cursor.getString(8));

                sellers.add(seller);
            } while (cursor.moveToNext());
        }
=======
    public int count() {
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM " + TABLE_NAME;
>>>>>>> Stashed changes:app/src/main/java/com/example/mad_2020_project/DbHandler.java

        Cursor cursor=db.rawQuery(query, null);
        return cursor.getCount();
    }

<<<<<<< Updated upstream:app/src/main/java/com/example/mad_2020_project/SellerDbHandler.java
    public void deleteSeller(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }

    public Seller getSingleSeller(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,NAME,EMAIL,PHONENO,LOCATION,WORKERS,FROMDATE,TODATE,PASSWORD},ID + "= ?",new String[]{String.valueOf(id)},null,null,null);

            Seller seller;
        if (cursor != null){
            cursor.moveToFirst();
            seller = new Seller(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8)
            );
            return seller;
=======
    //get all todos into a list
    public List<ToDo> getAllToDos() {
        List<ToDo> toDos=new ArrayList();
        Cursor cursor;
        try (SQLiteDatabase db=getReadableDatabase()) {
            String query="SELECT * FROM " + TABLE_NAME;

            cursor=db.rawQuery(query, null);
        }

        if (cursor.moveToFirst()) {
            do {
                ToDo todo=new ToDo();
                todo.setId(cursor.getInt(0));
                todo.setName(cursor.getString(1));
                todo.setPrice(cursor.getString(2));
                todo.setStarted(cursor.getLong(3));
                todo.setFinished(cursor.getLong(4));
            } while (cursor.moveToNext());
>>>>>>> Stashed changes:app/src/main/java/com/example/mad_2020_project/DbHandler.java
        }
        return toDos;
    }

<<<<<<< Updated upstream:app/src/main/java/com/example/mad_2020_project/SellerDbHandler.java
    public int updateSingleSeller(Seller seller){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME,seller.getName());
        contentValues.put(EMAIL,seller.getEmail());
        contentValues.put(PHONENO,seller.getPhoneNo());
        contentValues.put(LOCATION,seller.getLocation());
        contentValues.put(WORKERS,seller.getWorkers());
        contentValues.put(FROMDATE,seller.getFromDate());
        contentValues.put(TODATE,seller.getToDate());
        contentValues.put(PASSWORD,seller.getPassword());

        int status = db.update(TABLE_NAME,contentValues,ID +" =?",new String[]{String.valueOf(seller.getId())});

=======
    public void deleteitem(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,ID +"=?",new String[]{String.valueOf(id)});
>>>>>>> Stashed changes:app/src/main/java/com/example/mad_2020_project/DbHandler.java
        db.close();
    }
}
