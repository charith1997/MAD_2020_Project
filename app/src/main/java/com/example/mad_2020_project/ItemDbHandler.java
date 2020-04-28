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
    private static final String DB_NAME = "foodItemDB";
    private static final String TABLE_NAME = "foodItemDB";

    private static final String ITEMID = "itemId";
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
                + ITEMID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
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
                item.setQuantity(cursor.getInt(3));
                item.setLocation(cursor.getString(4));

                items.add(item);
            } while (cursor.moveToNext());
        }
        return items;
    }
}
