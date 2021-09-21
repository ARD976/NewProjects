package com.example.dsachat

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context , DATABASE_NAME , null , DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "DsaDatabase"
        private const val DATABASE_VERSION = 1
        private const val TABLE_CONTACTS = "dsaTable"
        private const val KEY_ID = "_id"
        private const val KEY_TYPE = "type"
        private const val KEY_COUNT = "count"
        private const val KEY_DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TYPE + " TEXT,"
                + KEY_COUNT + " INTEGER," + KEY_DATE + " TEXT" + ")")
        db?.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")
        onCreate(db)
    }

    fun addDSA(dsa : DSA) : Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_TYPE , dsa.type)
        contentValues.put(KEY_COUNT , dsa.count)
        contentValues.put(KEY_DATE , dsa.date)
        val success = db.insert(TABLE_CONTACTS , null , contentValues)
        db.close()
        return success
    }

    fun viewDSA() : ArrayList<DSA> {
        val list = ArrayList<DSA>()
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_CONTACTS"
        var cursor : Cursor? = null
        try {
            cursor = db.rawQuery(selectQuery , null)
        }catch(e : SQLException){
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id : Int
        var type : String
        var count : Int
        var date : String
        if(cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                type = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
                count = cursor.getInt(cursor.getColumnIndex(KEY_COUNT))
                date = cursor.getString(cursor.getColumnIndex(KEY_DATE))

                 val dsa = DSA(id , type , count , date)
                 list.add(dsa)
            }while(cursor.moveToNext())
        }
        return list
    }

    fun updateDSA(dsa : DSA) : Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_TYPE , dsa.type)
        contentValues.put(KEY_COUNT , dsa.count)
        contentValues.put(KEY_DATE , dsa.date)
        val success = db.update(TABLE_CONTACTS , contentValues , KEY_ID + "=" + dsa.id , null)
        db.close()
        return success
    }

    fun deleteDSA(dsa : DSA) : Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID , dsa.id)
        val success = db.delete(TABLE_CONTACTS , KEY_ID + "=" + dsa.id , null)
        db.close()
        return success
    }


}