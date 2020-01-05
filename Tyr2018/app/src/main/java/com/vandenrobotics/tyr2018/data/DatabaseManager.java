package com.vandenrobotics.tyr2018.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

/**
 * Created by Programming701-A on 12/18/2017.
 */

public class DatabaseManager {

    private Integer mOpenCounter = 0;

    private static DatabaseManager instance;
    private static SQLiteOpenHelper mDatabaseHelper;
    private SQLiteDatabase mDatabase;

    public static synchronized void initializedInstance(SQLiteOpenHelper helper){
        if (instance == null){
            instance = new DatabaseManager();
            mDatabaseHelper = helper;
        }
    }

    public static synchronized DatabaseManager getInstance(){
        if(instance == null){
            throw new IllegalStateException(DatabaseManager.class.getSimpleName() +
                " is not initialized, call initializeInstance(...) method first.");
        }
        return instance;
    }

    public synchronized SQLiteDatabase openDatabase(){
        mOpenCounter++;
        if(mOpenCounter == 1){
            mDatabase = SQLiteDatabase.openDatabase(Environment.getExternalStorageDirectory() + "/data/Tyr2018/TabletData.db", null, SQLiteDatabase.OPEN_READONLY);
        }
        return mDatabase;
    }

    public synchronized void closeDatabase(){
        mOpenCounter--;
        if(mOpenCounter == 0){
            mDatabase.close();
        }
    }
}
