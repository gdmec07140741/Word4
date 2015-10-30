package com.example.administrator.word4;

/**
 * Created by Administrator on 2015/10/30.
 */
public class MyUser {
    public static String getMoblie() {
        return moblie;
    }

    public static void setMoblie(String moblie) {
        MyUser.moblie = moblie;
    }

    public static void setName(String name) {
        MyUser.name = name;
    }

    public static String getDdanwei() {
        return ddanwei;
    }

    public static void setDdanwei(String ddanwei) {
        MyUser.ddanwei = ddanwei;
    }

    public static String getQq() {
        return qq;
    }

    public static void setQq(String qq) {
        MyUser.qq = qq;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        MyUser.address = address;
    }

    public static int getId_DB() {
        return id_DB;
    }

    public static void setId_DB(int id_DB) {
        MyUser.id_DB = id_DB;
    }

    public static String getName() {
        return name;
    }

    private static String name;
    private  static String moblie;
    private static String ddanwei;
    private static  String qq;
    private static  String address;
    private static  int id_DB=-1;

}
