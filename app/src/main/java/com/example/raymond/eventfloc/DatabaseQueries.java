package com.example.raymond.eventfloc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by RAYMOND on 18/04/2015.
 */
public class DatabaseQueries extends SQLiteOpenHelper {

    private static final String DB_NAME = "Event_Floc.db";
    private static final int DB_VERSION = 1;

    private static final String TABLE_USER = "User";
    private static final String TABLE_STUDENT = "Student";
    private static final String TABLE_SOCIETY = "Society";
    private static final String TABLE_ADMIN = "Admin";
    private static final String TABLE_EVENT = "Event";
    private static final String TABLE_EVENT_TYPE = "Event_Type";
    private static final String TABLE_FOLLOW_SOCIETY = "Follow_Society";
    private static final String TABLE_HAS_CATEGORY = "Has_Category";
    private static final String TABLE_ATTENDS = "Attends";
    private static final String TABLE_COMMENT = "Comment";

    //Not sure why these variables are public... just following a tutorial
    public static final String USER_ID = "user_id";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_PASSWORD = "user_password";
    public static final String STUDENT_ID = "student_id";
    public static final String STUDENT_FIRSTNAME = "first_name";
    public static final String STUDENT_LASTNAME = "last_name";
    public static final String SOCIETY_ID = "society_id";
    public static final String SOCIETY_NAME = "society_name";
    public static final String SOCIETY_APPROVAL_DATE = "approval_date";
    public static final String SOCIETY_DESC = "society_desc";
    public static final String SOCIETY_FACULTY = "society_faculty";
    public static final String ADMIN_ID = "admin_id";
    public static final String EVENT_ID = "event_id";
    public static final String EVENT_LOCATION = "event_location";
    public static final String EVENT_DATE = "event_date";
    public static final String EVENT_DESC = "event_desc";
    public static final String EVENT_LINK = "event_link";
    public static final String EVENT_START_TIME = "event_start_time";
    public static final String EVENT_END_TIME = "event_end_time";
    public static final String EVENT_TYPE_ID = "event_type_id";
    public static final String EVENT_TYPE = "event_type";
    public static final String ATTEND_STATUS = "attend_status";
    public static final String COMMENT_ID = "comment_id";
    public static final String COMMENT_DATE = "comment_date";
    public static final String COMMENT_TEXT = "comment_text";


    private static final String CREATE_TABLE_USER = "create table " + TABLE_USER + " ("
            + USER_ID + " integer(7) primary key autoincrement, "
            + USER_EMAIL + " varchar2 NOT NULL, "
            + USER_PASSWORD + " varchar2 NOT NULL"
            + " constraint password_ck check (password like '%[0-9]%' "
            + " and password like '%[A-Z]%' and len(password) >=8);";

    private static final String CREATE_TABLE_STUDENT = "create table " + TABLE_STUDENT + " ("
            + STUDENT_ID + " varchar primary key NOT NULL, "
            + USER_ID + " integer foreign key references TABLE_USER(user_id) NOT NULL, "
            + STUDENT_FIRSTNAME + " varchar2(20) NOT NULL, "
            + STUDENT_LASTNAME + " varchar2(20) NOT NULL);";


    private static final String CREATE_TABLE_SOCIETY = "create table " + TABLE_SOCIETY + " ("
            + SOCIETY_ID + " integer(7) primary key autoincrement, "
            + USER_ID + " integer(7) foreign key references TABLE_USER(user_id), "
            + SOCIETY_NAME + " varchar2(50) NOT NULL, "
            + SOCIETY_APPROVAL_DATE + " date, "
            + SOCIETY_DESC + " blob, "
            + SOCIETY_FACULTY + " varchar2(25));";


    private static final String CREATE_TABLE_ADMIN = "create table " + TABLE_ADMIN + " ( "
            + ADMIN_ID + " integer(7) primary key autoincrement, "
            + USER_ID + " integer(7) foreign key references TABLE_USER(user_id)); ";

    private static final String CREATE_TABLE_EVENT = "create table " + TABLE_EVENT + " ( "
            + EVENT_ID + " integer(7) primary key autoincrement, "
            + SOCIETY_ID + " integer(7) foreign key references TABLE_SOCIETY(society_id),"
            + EVENT_LOCATION + " varchar2,"
            + EVENT_DATE + " date,"
            + EVENT_DESC + " varchar2,"
            + EVENT_LINK + " varchar2,"
            + EVENT_START_TIME + " time,"
            + EVENT_END_TIME + " time);";

    private static final String CREATE_TABLE_EVENT_TYPE = "create table " + TABLE_EVENT_TYPE + " ( "
            + EVENT_TYPE_ID + " integer(7) primary key autoincrement, "
            + EVENT_TYPE + " varchar2);";

    private static final String CREATE_TABLE_FOLLOW_SOCIETY = "create table " + TABLE_FOLLOW_SOCIETY + " ( "
            + STUDENT_ID + " integer(7) foreign key references TABLE_STUDENT(student_id), "
            + SOCIETY_ID + " integer(7) foreign key references TABLE_SOCIETY(society_id),"
            + USER_ID + " integer(7) foreign key references TABLE_USER(user_id)); ";

    private static final String CREATE_TABLE_HAS_CATEGORY = "create table " + TABLE_HAS_CATEGORY + " ( "
            + EVENT_ID + " integer(7) foreign key references TABLE_EVENT(event_id), "
            + EVENT_TYPE_ID + " integer(7) foreign key references TABLE_EVENT_TYPE(event_type_id)); ";

    private static final String CREATE_TABLE_ATTENDS = "create table " + TABLE_ATTENDS + " ( "
            + EVENT_ID + " integer(7) foreign key references TABLE_EVENT(event_id), "
            + USER_ID + " integer(7) foreign key references TABLE_USER(user_id),"
            + STUDENT_ID + " integer(7) foreign key references TABLE_STUDENT(student_id),"
            + ATTEND_STATUS + " varchar2);";

    private static final String CREATE_TABLE_COMMENT = "create table " + TABLE_COMMENT + " ( "
            + COMMENT_ID + "integer(7) primary key autoincrement, "
            + USER_ID + "integer(7) foreign key references TABLE_USER(user_id), "
            + COMMENT_DATE + "date, "
            + COMMENT_TEXT + "blob);";
    private static final String STUDENT_USER_ID = "";


    public DatabaseQueries(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_STUDENT);
        db.execSQL(CREATE_TABLE_SOCIETY);
        db.execSQL(CREATE_TABLE_ADMIN);
        db.execSQL(CREATE_TABLE_EVENT);
        db.execSQL(CREATE_TABLE_EVENT_TYPE);
        db.execSQL(CREATE_TABLE_FOLLOW_SOCIETY);
        db.execSQL(CREATE_TABLE_HAS_CATEGORY);
        db.execSQL(CREATE_TABLE_ATTENDS);
        db.execSQL(CREATE_TABLE_COMMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SOCIETY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT_TYPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOLLOW_SOCIETY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HAS_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENT);
        onCreate(db);
    }

    /**
     * Insert a new User
     * @param user
     * @return
     */
    public void insertUser(User user){
        ContentValues cv = new ContentValues();

        cv.put(USER_EMAIL, user.getUserEmail());
        cv.put(USER_PASSWORD, String.valueOf(user.getPassword()));

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_USER, null, cv);
        db.close();
    }

    /**
     * Insert a new Student
     * @param student
     * @return
     */
    public void insertStudent(Student student){
        ContentValues cv = new ContentValues();

        insertUser(student);

        cv.put(STUDENT_ID, student.getStudentID());
        cv.put(STUDENT_USER_ID, student.getUserID());
        cv.put(STUDENT_FIRSTNAME, student.getFirstName());;
        cv.put(STUDENT_LASTNAME, student.getLastName());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_STUDENT, null, cv);
        db.close();
    }

    public void addUser(User user) {
        ContentValues values = new ContentValues();
        values.put(USER_ID, user.getUserID());
        values.put(USER_EMAIL, user.getUserEmail());
        values.put(USER_PASSWORD, String.valueOf(user.getPassword()));

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public User findUserEmail(String email) {
        String query = "Select * FROM " + TABLE_USER + " WHERE "
                + USER_EMAIL + " = \"" + email + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        User user = new User();

        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            user.setUserID(Integer.parseInt(cursor.getString(0)));
            user.setUserEmail(cursor.getString(1));
            user.setPassword(cursor.getString(2));
            cursor.close();
        } else {
            user = null;
        }
        db.close();
        return user;
    }

    public boolean requestLogin(String email, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        boolean correctPassword = false;
        String hashPassword = PasswordHash.createHash(password);
        String query = "Select " + USER_PASSWORD + " FROM " + TABLE_USER + " WHERE "
                + USER_EMAIL + " = \"" + email + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        String storedPassword;

        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            storedPassword = cursor.getString(0);
            cursor.close();
        } else {
            storedPassword = null;
        }
        db.close();

        if(hashPassword.equals(storedPassword)) {
            correctPassword = true;
        } else {
            correctPassword = false;
        }
        return correctPassword;
    }

    public boolean deleteUser(int userID) {
        boolean result = false;

        String query = "Select * FROM " + TABLE_USER + " where " + USER_ID
                + " = \"" + userID + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        User user = new User();

        if(cursor.moveToFirst()) {
            user.setUserID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_USER, USER_ID + " = ?",
                    new String[] { String.valueOf(user.getUserID()) });
            cursor.close();

        }
        return result;
    }


}
