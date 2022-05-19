package hcmute.edu.vn.nhom07.foodyapp_group07;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class StoreDatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "storeManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Store";

    private static final String COLUMN_ID_STORE ="storeId";
    private static final String COLUMN_IMG_STORE = "storeImg";
    private static final String COLUMN_NAME_STORE = "storeName";
    private static final String COLUMN_RATE = "storeRate";
    private static final String COLUMN_REVIEWS = "storeReviews";
    private static final String COLUMN_ADDRESS = "storeAddress";
    private static final String COLUMN_DISTANCE = "storeDistance";
    private static final String COLUMN_DEAL = "isDeal";

    public StoreDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_stores = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s REAL, %s INTEGER, %s TEXT, %s REAL, %s NUMERIC)",
                TABLE_NAME, COLUMN_ID_STORE, COLUMN_IMG_STORE, COLUMN_NAME_STORE, COLUMN_RATE, COLUMN_REVIEWS, COLUMN_ADDRESS, COLUMN_DISTANCE, COLUMN_DEAL);
        db.execSQL(create_stores);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String drop_stores_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_stores_table);

        onCreate(db);

    }

    public void addStore(Store store) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID_STORE, store.getStoreID());
        values.put(COLUMN_IMG_STORE, store.getStoreImg());
        values.put(COLUMN_NAME_STORE, store.getStoreName());
        values.put(COLUMN_RATE, store.getStoreRate());
        values.put(COLUMN_REVIEWS, store.getStoreReviews());
        values.put(COLUMN_ADDRESS, store.getStoreAddress());
        values.put(COLUMN_DISTANCE, store.getStoreDistance());
        values.put(COLUMN_DEAL, store.isDeal());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Store getStore(int storeId) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_ID_STORE + " = ?", new String[] { String.valueOf(storeId) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Store store = new Store(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getDouble(3),
                cursor.getInt(4), cursor.getString(5), cursor.getDouble(6), (cursor.getInt(7) != 0));
        return store;
    }

    public List<Store> getAllStore() {
        List<Store>  storeList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Store store = new Store(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getDouble(3),
                    cursor.getInt(4), cursor.getString(5), cursor.getDouble(6), (cursor.getInt(7) != 0));
            storeList.add(store);
            cursor.moveToNext();
        }
        return storeList;
    }
}
