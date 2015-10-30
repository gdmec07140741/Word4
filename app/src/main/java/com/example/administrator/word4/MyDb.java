package com.example.administrator.word4;

/**
 * Created by Administrator on 2015/10/30.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDb extends SQLiteOpenHelper {

    private  static  String DB_Name ="My_DB.db";
    private static int DB_VERSION=2;
    private  SQLiteDatabase db ;
    public MyDb(Context context) {
        super(context,DB_Name,null,DB_VERSION);
        db=getWritableDatabase();

    }
    public SQLiteDatabase openConnect(){
        db = getWritableDatabase();
        return db;
    }
    public void closeSQlConn(){
        db.close();
    }
    public boolean  CreatTabel(String CreateSqlTabel){
        try {
            openConnect();
            db.execSQL(CreateSqlTabel);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally{
            closeSQlConn();
        }
        return true;
    }
    public boolean save(String tableName ,ContentValues values){
        try{
            openConnect();
            db.insert(tableName, null, values);
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }finally{
            closeSQlConn();
        }
        return true;
    }
    public  boolean update(String table,ContentValues values,String whereCla,String []whereArgs){
        try {
            openConnect();
            db.update(table, values, whereCla, whereArgs);
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            closeSQlConn();
        }
        return true;
    }
    public boolean deleterSql (String table,String deletesql,String obj[]){

        try {
            openConnect();
            db.delete(table, deletesql, obj);
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            closeSQlConn();
        }
        return true;
    }
    public  Cursor find(String findSql,String obj[]){

        openConnect();
        Cursor cursor =db.rawQuery(findSql,obj);
        return cursor;


    }
    public boolean isTableExit(String tableName){
        try {
            openConnect();
            String str ="select count(*)xcount from "+tableName;
            db.rawQuery(str,null).close();
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

