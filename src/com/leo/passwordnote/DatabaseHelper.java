package com.leo.passwordnote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	final String CREATE_TABLE_SQL =
			"create table passwordNote(_id integer primary key autoincrement," +
			" key VARCHAR(20) UNIQUE , content VARCHAR)";
	
	
	public DatabaseHelper(Context context, String name,
			 int version) {
		
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_SQL);
		Log.d("DB","onCreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		System.out.println("--------onUpdate Called--------" 
				+ oldVersion + "--->" + newVersion);
	}
	
	public boolean insert(String key, String content)
	{
		SQLiteDatabase db = null;
		try
		{
			db = this.getWritableDatabase();
			Object[] args = new Object[]{key,content};
			db.execSQL("insert into passwordNote values(null, ?, ?)",
					args);
			Log.d("DataBase", "insert..."+key);
			
			return true;
		}catch(SQLiteException e){
			Log.e("DataBase",e.getMessage());
			return false;
		}finally{
			
			if(db.isOpen())
			{
				db.close();
			}
		}
		
	}
	public String getContent(String key)
	{
		String content = null;
		Cursor cursor = null;
		SQLiteDatabase db = null;
		String sql = "select * from passwordNote where key = ?";
		
		try
		{
			db = this.getReadableDatabase();
			cursor = db.rawQuery(sql, new String[]{key});
			cursor.moveToFirst();
			while(!cursor.isAfterLast())
			{
				content = cursor.getString(2);
				cursor.moveToNext();
			}
			
			Log.e("DataBase","getContent:"+content);
			return content;
		}catch(SQLiteException e){
			Log.e("DataBase",e.getMessage());
			return null;
		}finally{
			if(!cursor.isClosed())
			{
				cursor.close();
			}
			
			if(db.isOpen())
			{
				db.close();
			}
		}
	}
	public boolean isKeyExist(String key)
	{
		Cursor cursor = null;
		SQLiteDatabase db = null;
		String sql = "select * from passwordNote where key = ?";
		
		try
		{
			db = this.getReadableDatabase();
			cursor = db.rawQuery(sql, new String[]{key});
			
			boolean isExist = (cursor.moveToFirst() && cursor.getCount() > 0);
			
			return isExist;
		}catch(SQLiteException e){
			Log.e("DataBase",e.getMessage());
			return false;
		}finally{
			if(!cursor.isClosed())
			{
				cursor.close();
			}
			
			if(db.isOpen())
			{
				db.close();
			}
		}
		
	}
	
	public boolean update(String key, String content)
	{
		SQLiteDatabase db = null;
		try
		{
			db = this.getWritableDatabase();
			ContentValues cv = new ContentValues();
			cv.put("content", content);
//			Object[] args = new Object[]{key,content};
//			db.execSQL("update passwordNote set content=? where key like ?",
//					args);
			int i = db.update("passwordNote", cv, "key = ?", new String[]{key});
			Log.d("DataBase", "update..."+i+" data");
			
			return true;
		}catch(SQLiteException e){
			Log.e("DataBase",e.getMessage());
			return false;
		}finally{
			
			if(db.isOpen())
			{
				db.close();
			}
		}
	}
	
	
	
	public void close()
	{
		SQLiteDatabase db = this.getWritableDatabase();
		if(db.isOpen())
		{
			db.close();
		}
		Log.d("DataBase","close()...");
	}
	
	

}
