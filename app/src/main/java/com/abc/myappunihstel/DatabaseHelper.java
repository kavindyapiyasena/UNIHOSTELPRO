package com.abc.myappunihstel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database info
    private static final String DATABASE_NAME = "MyAppDB.db";
    private static final int DATABASE_VERSION = 1;

    // ------------------- TABLE USERS -------------------
    private static final String TABLE_USERS = "users";
    private static final String COL_USER_ID = "id";
    private static final String COL_USERNAME = "username";
    private static final String COL_PASSWORD = "password";

    // ------------------- TABLE DATA -------------------
    private static final String TABLE_DATA = "data";
    private static final String COL_DATA_ID = "id";
    private static final String COL_TITLE = "title";
    private static final String COL_CONTENT = "content";

    // ------------------- TABLE STUDENT -------------------
    private static final String TABLE_STUDENT = "student";
    private static final String COL_STUDENT_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_REGNO = "regNo";
    private static final String COL_NIC = "nic";
    private static final String COL_FACULTY = "faculty";
    private static final String COL_YEAR = "year";
    private static final String COL_PROGRAM = "program";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Users Table
        db.execSQL("CREATE TABLE " + TABLE_USERS + " (" +
                COL_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERNAME + " TEXT UNIQUE, " +
                COL_PASSWORD + " TEXT)");

        // Create Data Table
        db.execSQL("CREATE TABLE " + TABLE_DATA + " (" +
                COL_DATA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_TITLE + " TEXT, " +
                COL_CONTENT + " TEXT)");

        // Create Student Table
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
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
        long result = db.insert(TABLE_USERS, null, cv);
        db.close();
        return result != -1;
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,
                new String[]{COL_USER_ID},
                COL_USERNAME + "=? AND " + COL_PASSWORD + "=?",
                new String[]{username, password},
                null, null, null);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        db.close();
        return exists;
    }

    // ------------------- DATA METHODS -------------------
    public boolean insertData(String title, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, title);
        cv.put(COL_CONTENT, content);
        long result = db.insert(TABLE_DATA, null, cv);
        db.close();
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
        db.close();
        return result > 0;
    }

    public boolean deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_DATA, COL_DATA_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
        return result > 0;
    }

    // ------------------- STUDENT METHODS -------------------
    public boolean insertStudent(String name, String regNo, String nic, String faculty, String year, String program) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, name);
        cv.put(COL_REGNO, regNo);
        cv.put(COL_NIC, nic);
        cv.put(COL_FACULTY, faculty);
        cv.put(COL_YEAR, year);
        cv.put(COL_PROGRAM, program);
        long result = db.insert(TABLE_STUDENT, null, cv);
        db.close();
        return result != -1;
    }

    public Cursor getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_STUDENT, null);
    }
}
