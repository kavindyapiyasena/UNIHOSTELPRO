package com.abc.myappunihstel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database name and version
    public static final String DATABASE_NAME = "MyApp.db";
    public static final int DATABASE_VERSION = 1;

    // User table
    public static final String TABLE_USER = "users";
    public static final String COL_USER_ID = "id";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";

    // Data table
    public static final String TABLE_DATA = "data";
    public static final String COL_DATA_ID = "id";
    public static final String COL_TITLE = "title";
    public static final String COL_CONTENT = "content";

    // Student table
    public static final String TABLE_STUDENT = "student";
    public static final String COL_STUDENT_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_REGNO = "regNo";
    public static final String COL_NIC = "nic";
    public static final String COL_FACULTY = "faculty";
    public static final String COL_YEAR = "year";
    public static final String COL_PROGRAM = "program";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create users table
        db.execSQL("CREATE TABLE " + TABLE_USER + " (" +
                COL_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERNAME + " TEXT UNIQUE, " +
                COL_PASSWORD + " TEXT)");

        // Create data table
        db.execSQL("CREATE TABLE " + TABLE_DATA + " (" +
                COL_DATA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_TITLE + " TEXT, " +
                COL_CONTENT + " TEXT)");

        // Create student table
        db.execSQL("CREATE TABLE " + TABLE_STUDENT + " (" +
                COL_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_REGNO + " TEXT, " +
                COL_NIC + " TEXT, " +
                COL_FACULTY + " TEXT, " +
                COL_YEAR + " TEXT, " +
                COL_PROGRAM + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop old tables if upgrading
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);
    }

    // ------------------- USER METHODS -------------------
    public boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_USERNAME, username);
        cv.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_USER, null, cv);
        return result != -1;
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER + " WHERE " +
                COL_USERNAME + " = ? AND " + COL_PASSWORD + " = ?", new String[]{username, password});
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }

    // ------------------- DATA METHODS -------------------
    public boolean insertData(String title, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, title);
        cv.put(COL_CONTENT, content);
        long result = db.insert(TABLE_DATA, null, cv);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_DATA, null);
    }

    public boolean updateData(int id, String title, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, title);
        cv.put(COL_CONTENT, content);
        int result = db.update(TABLE_DATA, cv, COL_DATA_ID + "=?", new String[]{String.valueOf(id)});
        return result > 0;
    }

    public boolean deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_DATA, COL_DATA_ID + "=?", new String[]{String.valueOf(id)});
        return result > 0;
    }

    // ------------------- STUDENT METHODS -------------------
    public boolean insertStudent(String name, String regNo, String nic, String faculty, String year, String program) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_REGNO, regNo);
        values.put(COL_NIC, nic);
        values.put(COL_FACULTY, faculty);
        values.put(COL_YEAR, year);
        values.put(COL_PROGRAM, program);

        long result = db.insert(TABLE_STUDENT, null, values);
        db.close();
        return result != -1;
    }

    public Cursor getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_STUDENT, null);
    }
}
