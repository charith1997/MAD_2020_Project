package com.example.mad_2020_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemDbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "FoodItemDB";
    private static final String TABLE_NAME = "FoodItemDB";

    private static final String ID = "id";
    private static final String FOODNAME = "foodName";
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";
    private static final String LOCATION = "location";

    public ItemDbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + FOODNAME + " TEXT,"
                + PRICE + " TEXT,"
                + QUANTITY + " TEXT,"
                + LOCATION + " TEXT" +
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

    public void addFoodItem(Item item){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(FOODNAME,item.getName());
        contentValues.put(PRICE,item.getPrice());
        contentValues.put(QUANTITY,item.getQuantity());
        contentValues.put(LOCATION,item.getLocation());

        //  Save to Table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        // Close Database
        sqLiteDatabase.close();
    }

    public List<Item> getAllItems(){
        List<Item> items = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                Item item = new Item();
                item.setId(cursor.getInt(0));
                item.setName(cursor.getString(1));
                item.setPrice(cursor.getString(2));
                item.setQuantity(cursor.getString(3));
                item.setLocation(cursor.getString(4));

                items.add(item);
            } while (cursor.moveToNext());
        }
        return items;
    }

    public void deleteItem(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }

    public Item getSingleItem(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,FOODNAME,PRICE,QUANTITY,LOCATION},ID + "= ?",new String[]{String.valueOf(id)},null,null,null);

        Item item;
        if (cursor != null){
            cursor.moveToFirst();
            item = new Item(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
            return item;
        }
        return null;
    }

    public int updateSingleItem(Item item){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(FOODNAME,item.getName());
        contentValues.put(PRICE,item.getPrice());
        contentValues.put(QUANTITY,item.getQuantity());
        contentValues.put(LOCATION,item.getLocation());

        int status = db.update(TABLE_NAME,contentValues,ID +" =?",new String[]{String.valueOf(item.getId())});

        db.close();

        return status;
    }
}
