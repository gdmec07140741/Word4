package com.example.administrator.word4;


import android.content.ContentValues;
import android.content.Context;
/**
 * Created by Administrator on 2015/10/30.
 */
import android.content.ContentValues;
import android.content.Context;

public class ContentTable {
    private  final static String TABLENAME="contactsTable";
    private  MyDb db;
    public ContentTable(Context context){
        db =new MyDb(context);
        if(!db.isTableExit(TABLENAME)){
            String createtableSql = "create table if not exists"+TABLENAME+"(id_DB integer,"+"primary key AUTOINCREMENT,"+
                    MyUser.getName() +"VARCHAR,"+
                    MyUser.getMoblie()+"VARCHAR,"+
                    MyUser.getQq()+"VARCHAR,"+
                    MyUser.getDdanwei()+"VARCHAR,"+
                    MyUser.getAddress()+"VARCHAR,";
            db.CreatTabel(createtableSql);
        }
    }
    public boolean addData(MyUser user){
        ContentValues values = new ContentValues();
        values.put(MyUser.getName(),user.getName());
        values.put(MyUser.getMoblie(),user.getMoblie());
        values.put(MyUser.getQq(),user.getQq());
        values.put(MyUser.getDdanwei(),user.getDdanwei());
        values.put(MyUser.getAddress(),user.getAddress());
        return db.save(TABLENAME,values);
    }
}
