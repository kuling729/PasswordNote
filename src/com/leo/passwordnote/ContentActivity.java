package com.leo.passwordnote;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.leo.imageloader.R;
import com.leo.utils.Convert;
import com.leo.utils.File3DES;
import com.leo.utils.FileUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContentActivity extends Activity {

	SharedPreferences sharedPreferences;
	Editor editor;
	DatabaseHelper dbHelper;
	private EditText etContent;
	private Button btnSave;
	private Button btnSaveToHex;
	private Button btnReadFile;
	private final static String SDPath = Environment
			.getExternalStorageDirectory().getPath();
	private final static String encodefile = SDPath + "/encode.txt";
	private final static String decodefile = SDPath + "/decode.txt";
	File file = new File(encodefile);
	String keyStr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content);

		dbHelper = new DatabaseHelper(this, "pwd.db", 1);

		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		// editor = sharedPreferences.edit();
		etContent = (EditText) findViewById(R.id.editText1);

		btnReadFile = (Button) findViewById(R.id.btnRead);
		btnReadFile.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(file.exists())
				{
				try {
					
					String str = FileUtil.getStringFromFile(file);
					byte[] buffer = Convert.hexStringToBytes(str);
					byte[] srcBytes = File3DES.decryptMode("12345678", keyStr,
							buffer);
					if (srcBytes.length != 0) {
						String decodeStr = new String(srcBytes);
						Log.e("STR", "解密后的字符串:" + decodeStr);
						etContent.setText(decodeStr);
						Toast.makeText(ContentActivity.this, "读取成功",
								Toast.LENGTH_SHORT).show();
					}
					else
					{
						etContent.setText("");
						Toast.makeText(ContentActivity.this, "读取失败",
								Toast.LENGTH_SHORT).show();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					etContent.setText("");
					Toast.makeText(ContentActivity.this, "读取失败，返回重新输入密钥",
							Toast.LENGTH_SHORT).show();
				}
				}
				else
				{
					Toast.makeText(ContentActivity.this, "读取"+encodefile+"失败,文件不存在",
							Toast.LENGTH_SHORT).show();
				}
			}

		});
		btnSaveToHex = (Button) findViewById(R.id.btnSaveto);
		btnSaveToHex.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String szSrc = etContent.getText().toString();
				if (!szSrc.equals("")) {
					Log.e("STR", "加密前的字符串:" + szSrc);

					byte[] encoded = File3DES.encryptMode("12345678", keyStr,
							szSrc);
					String encodeStr = Convert.convertBytesToString(encoded, 0,
							encoded.length);
					Log.e("STR", "加密后的字符串:" + encodeStr);
					// if (dbHelper.isKeyExist(keyStr)) {
					// dbHelper.update(keyStr, encodeStr);
					// Log.e("STR", "修改到数据库");
					// } else {
					// dbHelper.insert(keyStr, encodeStr);
					// Log.e("STR", "添加到数据库");
					// }

					FileOutputStream fout;
					try {
						fout = new FileOutputStream(file);
						fout.write(encodeStr.getBytes());
						fout.close();
						Toast.makeText(ContentActivity.this,
								"保存到" + encodefile, Toast.LENGTH_SHORT).show();
						Log.e("STR", "保存到" + encodefile);

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		});

		btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String szSrc = etContent.getText().toString();
				if (!szSrc.equals("")) {
					Log.e("STR", "加密前的字符串:" + szSrc);

					byte[] encoded = File3DES.encryptMode("12345678", keyStr,
							szSrc);
					String encodeStr = Convert.convertBytesToString(encoded, 0,
							encoded.length);
					Log.e("STR", "加密后的字符串:" + encodeStr);
					if (dbHelper.isKeyExist(keyStr)) {
						dbHelper.update(keyStr, encodeStr);
						Log.e("STR", "修改到数据库");
					} else {
						dbHelper.insert(keyStr, encodeStr);
						Log.e("STR", "添加到数据库");
					}

					Toast.makeText(ContentActivity.this, "保存成功",
							Toast.LENGTH_SHORT).show();

				}
			}
		});

		keyStr = getIntent().getExtras().getString("key");
		if (dbHelper.isKeyExist(keyStr)) {
			String tmp = dbHelper.getContent(keyStr);
			byte[] encodeBytes = Convert.convertStringToBytes(tmp);
			byte[] srcBytes = File3DES.decryptMode("12345678", keyStr,
					encodeBytes);
			String decodeStr = new String(srcBytes);
			Log.e("STR", "解密后的字符串:" + decodeStr);
			etContent.setText(decodeStr);
		}

		

	}

}
