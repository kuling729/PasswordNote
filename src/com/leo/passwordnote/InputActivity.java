package com.leo.passwordnote;



import java.util.Locale;

import com.leo.imageloader.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends Activity implements OnClickListener{

	
	private boolean isUppercase = false;
	private int count = 0;
	
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	private Button btn9;
	private Button btn10;
	private Button btn11;
	private Button btn12;
	private Button btn13;
	private Button btn14;
	private Button btn15;
	private Button btn16;
	private Button btn17;
	private Button btn18;
	private Button btn19;
	private Button btn20;
	private Button btn21;
	private Button btn22;
	private Button btn23;
	private Button btn24;
	private Button btn25;
	private Button btn26;
	
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button button10;
	
	
	private Button btnDelete;
	private Button btnUP;
	private Button btnEnter;
	private EditText etPassword;
	private TextView tv;
	
	private void getWidgets()
	{
		btn1  = (Button)findViewById(R.id.btn1);
		btn2  = (Button)findViewById(R.id.btn2);
		btn3  = (Button)findViewById(R.id.btn3);
		btn4  = (Button)findViewById(R.id.btn4);
		btn5  = (Button)findViewById(R.id.btn5);
		btn6  = (Button)findViewById(R.id.btn6);
		btn7  = (Button)findViewById(R.id.btn7);
		btn8  = (Button)findViewById(R.id.btn8);
		btn9  = (Button)findViewById(R.id.btn9);
		btn10 = (Button)findViewById(R.id.btn10);
		btn11 = (Button)findViewById(R.id.btn11);
		btn12 = (Button)findViewById(R.id.btn12);
		btn13 = (Button)findViewById(R.id.btn13);
		btn14 = (Button)findViewById(R.id.btn14);
		btn15 = (Button)findViewById(R.id.btn15);
		btn16 = (Button)findViewById(R.id.btn16);
		btn17 = (Button)findViewById(R.id.btn17);
		btn18 = (Button)findViewById(R.id.btn18);
		btn19 = (Button)findViewById(R.id.btn19);
		btn20 = (Button)findViewById(R.id.btn20);
		btn21 = (Button)findViewById(R.id.btn21);
		btn22 = (Button)findViewById(R.id.btn22);
		btn23 = (Button)findViewById(R.id.btn23);
		btn24 = (Button)findViewById(R.id.btn24);
		btn25 = (Button)findViewById(R.id.btn25);
		btn26 = (Button)findViewById(R.id.btn26);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btn10.setOnClickListener(this);
		btn11.setOnClickListener(this);
		btn12.setOnClickListener(this);
		btn13.setOnClickListener(this);
		btn14.setOnClickListener(this);
		btn15.setOnClickListener(this);
		btn16.setOnClickListener(this);
		btn17.setOnClickListener(this);
		btn18.setOnClickListener(this);
		btn19.setOnClickListener(this);
		btn20.setOnClickListener(this);
		btn21.setOnClickListener(this);
		btn22.setOnClickListener(this);
		btn23.setOnClickListener(this);
		btn24.setOnClickListener(this);
		btn25.setOnClickListener(this);
		btn26.setOnClickListener(this);
		
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		button4 = (Button)findViewById(R.id.button4);
		button5 = (Button)findViewById(R.id.button5);
		button6 = (Button)findViewById(R.id.button6);
		button7 = (Button)findViewById(R.id.button7);
		button8 = (Button)findViewById(R.id.button8);
		button9 = (Button)findViewById(R.id.button9);
		button10 = (Button)findViewById(R.id.button10);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		button5.setOnClickListener(this);
		button6.setOnClickListener(this);
		button7.setOnClickListener(this);
		button8.setOnClickListener(this);
		button9.setOnClickListener(this);
		button10.setOnClickListener(this);
		
		etPassword = (EditText)findViewById(R.id.etPWD);
		
		btnDelete = (Button)findViewById(R.id.btnDEL);
//		btn4elete.setOnClickListener(this);
		
		btnUP = (Button)findViewById(R.id.btnUP);
//		btnUP.setOnClickListener(this);
		
		btnEnter = (Button)findViewById(R.id.btnEnter);
//		btnEnter.setOnClickListener(this);
		
		tv = (TextView)findViewById(R.id.textView1);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getWidgets();
		generalRandomButtonValue();
		btnDelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int index=etPassword.getText().length();     
				String str=etPassword.getText().toString();  
				if (!str.equals("")) {//判断输入框不为空，执行删除  
					etPassword.getText().delete(index-1,index); 
					count--;
					tv.setText(""+count);
				}
			}
		});
		
		btnUP.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				isUppercase = !isUppercase;
				if(isUppercase)
					setUppercase();
				else
					setLowercase();
			}
		});
		
		btnEnter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				intent.setClass(InputActivity.this, ContentActivity.class);
				String key=etPassword.getText().toString();  
				if (!key.equals("")) {
					bundle.putString("key", key);
					intent.putExtras(bundle);
					startActivity(intent);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void setUppercase()
	{
		
		btn1.setText(btn1.getText().toString().toUpperCase());
		btn2.setText(btn2.getText().toString().toUpperCase());
		btn3.setText(btn3.getText().toString().toUpperCase());
		btn4.setText(btn4.getText().toString().toUpperCase());
		btn5.setText(btn5.getText().toString().toUpperCase());
		btn6.setText(btn6.getText().toString().toUpperCase());
		btn7.setText(btn7.getText().toString().toUpperCase());
		btn8.setText(btn8.getText().toString().toUpperCase());
		btn9.setText(btn9.getText().toString().toUpperCase());
		btn10.setText(btn10.getText().toString().toUpperCase());
		btn11.setText(btn11.getText().toString().toUpperCase());
		btn12.setText(btn12.getText().toString().toUpperCase());
		btn13.setText(btn13.getText().toString().toUpperCase());
		btn14.setText(btn14.getText().toString().toUpperCase());
		btn15.setText(btn15.getText().toString().toUpperCase());
		btn16.setText(btn16.getText().toString().toUpperCase());
		btn17.setText(btn17.getText().toString().toUpperCase());
		btn18.setText(btn18.getText().toString().toUpperCase());
		btn19.setText(btn19.getText().toString().toUpperCase());
		btn20.setText(btn20.getText().toString().toUpperCase());
		btn21.setText(btn21.getText().toString().toUpperCase());
		btn22.setText(btn22.getText().toString().toUpperCase());
		btn23.setText(btn23.getText().toString().toUpperCase());
		btn24.setText(btn24.getText().toString().toUpperCase());
		btn25.setText(btn25.getText().toString().toUpperCase());
		btn26.setText(btn26.getText().toString().toUpperCase());
	}
	
	private void setLowercase()
	{
		btn1.setText(btn1.getText().toString().toLowerCase());
		btn2.setText(btn2.getText().toString().toLowerCase());
		btn3.setText(btn3.getText().toString().toLowerCase());
		btn4.setText(btn4.getText().toString().toLowerCase());
		btn5.setText(btn5.getText().toString().toLowerCase());
		btn6.setText(btn6.getText().toString().toLowerCase());
		btn7.setText(btn7.getText().toString().toLowerCase());
		btn8.setText(btn8.getText().toString().toLowerCase());
		btn9.setText(btn9.getText().toString().toLowerCase());
		btn10.setText(btn10.getText().toString().toLowerCase());
		btn11.setText(btn11.getText().toString().toLowerCase());
		btn12.setText(btn12.getText().toString().toLowerCase());
		btn13.setText(btn13.getText().toString().toLowerCase());
		btn14.setText(btn14.getText().toString().toLowerCase());
		btn15.setText(btn15.getText().toString().toLowerCase());
		btn16.setText(btn16.getText().toString().toLowerCase());
		btn17.setText(btn17.getText().toString().toLowerCase());
		btn18.setText(btn18.getText().toString().toLowerCase());
		btn19.setText(btn19.getText().toString().toLowerCase());
		btn20.setText(btn20.getText().toString().toLowerCase());
		btn21.setText(btn21.getText().toString().toLowerCase());
		btn22.setText(btn22.getText().toString().toLowerCase());
		btn23.setText(btn23.getText().toString().toLowerCase());
		btn24.setText(btn24.getText().toString().toLowerCase());
		btn25.setText(btn25.getText().toString().toLowerCase());
		btn26.setText(btn26.getText().toString().toLowerCase());
	}
	
	public static int[] randomCommon(int min, int max, int n){  
	    if (n > (max - min + 1) || max < min) {  
	           return null;  
	       }  
	    int[] result = new int[n];  
	    int cnt = 1;  
	    while(cnt < n) {  
	        int num = (int) (Math.random() * (max - min)) + min;  
	        boolean flag = true;  
	        for (int j = 0; j < n; j++) {  
	            if(num == result[j]){  
	                flag = false;  
	                break;  
	            }  
	        }  
	        if(flag){  
	            result[cnt-1] = num;  
	            cnt++;  
	        }  
	    }  
	    return result;  
	}  
	private void generalRandomButtonValue()
	{
		int[] index = randomCommon(0,26,26);
		int[] numIndex = randomCommon(0,10,10);
		String str = "abcdefghijklmnopqrstuvwxyz";
		int i=0;
		
		btn1.setText(""+str.charAt(index[0]));
		btn2.setText(""+str.charAt(index[1]));
		btn3.setText(""+str.charAt(index[2]));
		btn4.setText(""+str.charAt(index[3]));
		btn5.setText(""+str.charAt(index[4]));
		btn6.setText(""+str.charAt(index[5]));
		btn7.setText(""+str.charAt(index[6]));
		btn8.setText(""+str.charAt(index[7]));
		btn9.setText(""+str.charAt(index[8]));
		btn10.setText(""+str.charAt(index[9]));
		btn11.setText(""+str.charAt(index[10]));
		btn12.setText(""+str.charAt(index[11]));
		btn13.setText(""+str.charAt(index[12]));
		btn14.setText(""+str.charAt(index[13]));
		btn15.setText(""+str.charAt(index[14]));
		btn16.setText(""+str.charAt(index[15]));
		btn17.setText(""+str.charAt(index[16]));
		btn18.setText(""+str.charAt(index[17]));
		btn19.setText(""+str.charAt(index[18]));
		btn20.setText(""+str.charAt(index[19]));
		btn21.setText(""+str.charAt(index[20]));
		btn22.setText(""+str.charAt(index[21]));
		btn23.setText(""+str.charAt(index[22]));
		btn24.setText(""+str.charAt(index[23]));
		btn25.setText(""+str.charAt(index[24]));
		btn26.setText(""+str.charAt(index[25]));
		
		button1.setText(""+numIndex[0]);
		button2.setText(""+numIndex[1]);
		button3.setText(""+numIndex[2]);
		button4.setText(""+numIndex[3]);
		button5.setText(""+numIndex[4]);
		button6.setText(""+numIndex[5]);
		button7.setText(""+numIndex[6]);
		button8.setText(""+numIndex[7]);
		button9.setText(""+numIndex[8]);
		button10.setText(""+numIndex[9]);
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		count++;
		tv.setText(""+count);
		switch(v.getId())
		{
		
		case R.id.btn1:
			etPassword.append(btn1.getText().toString());
			Log.d("IN",btn1.getText().toString());
			break;
		case R.id.btn2:
			etPassword.append(btn2.getText().toString());
			Log.d("IN",btn2.getText().toString());
			
			break;
		case R.id.btn3:
			etPassword.append(btn3.getText().toString());
			Log.d("IN",btn3.getText().toString());
			break;
		case R.id.btn4:
			etPassword.append(btn4.getText().toString());
			Log.d("IN",btn4.getText().toString());
			break;
		case R.id.btn5:
			etPassword.append(btn5.getText().toString());
			Log.d("IN",btn5.getText().toString());
			break;
		case R.id.btn6:
			etPassword.append(btn6.getText().toString());
			Log.d("IN",btn6.getText().toString());
			break;
		case R.id.btn7:
			etPassword.append(btn7.getText().toString());
			Log.d("IN",btn7.getText().toString());
			break;
		case R.id.btn8:
			etPassword.append(btn8.getText().toString());
			Log.d("IN",btn8.getText().toString());
			break;
		case R.id.btn9:
			etPassword.append(btn9.getText().toString());
			Log.d("IN",btn9.getText().toString());
			break;
		case R.id.btn10:
			etPassword.append(btn10.getText().toString());
			Log.d("IN",btn10.getText().toString());
			break;
		case R.id.btn11:
			etPassword.append(btn11.getText().toString());
			break;
		case R.id.btn12:
			etPassword.append(btn12.getText().toString());
			break;
		case R.id.btn13:
			etPassword.append(btn13.getText().toString());
			break;
		case R.id.btn14:
			etPassword.append(btn14.getText().toString());
			break;
		case R.id.btn15:
			etPassword.append(btn15.getText().toString());
			break;
		case R.id.btn16:
			etPassword.append(btn16.getText().toString());
			break;
		case R.id.btn17:
			etPassword.append(btn17.getText().toString());
			break;
		case R.id.btn18:
			etPassword.append(btn18.getText().toString());
			break;
		case R.id.btn19:
			etPassword.append(btn19.getText().toString());
			break;
		case R.id.btn20:
			etPassword.append(btn20.getText().toString());
			break;
		case R.id.btn21:
			etPassword.append(btn21.getText().toString());
			break;
		case R.id.btn22:
			etPassword.append(btn22.getText().toString());
			break;
		case R.id.btn23:
			etPassword.append(btn23.getText().toString());
			break;
		case R.id.btn24:
			etPassword.append(btn24.getText().toString());
			break;
		case R.id.btn25:
			etPassword.append(btn25.getText().toString());
			break;
		case R.id.btn26:
			etPassword.append(btn26.getText().toString());
			break;
		case R.id.button1:
			etPassword.append(button1.getText().toString());
			break;
		case R.id.button2:
			etPassword.append(button2.getText().toString());
			break;
		case R.id.button3:
			etPassword.append(button3.getText().toString());
			break;
		case R.id.button4:
			etPassword.append(button4.getText().toString());
			break;
		case R.id.button5:
			etPassword.append(button5.getText().toString());
			break;
		case R.id.button6:
			etPassword.append(button6.getText().toString());
			break;
		case R.id.button7:
			etPassword.append(button7.getText().toString());
			break;
		case R.id.button8:
			etPassword.append(button8.getText().toString());
			break;
		case R.id.button9:
			etPassword.append(button9.getText().toString());
			break;
		case R.id.button10:
			etPassword.append(button10.getText().toString());
			break;
			
		}
	}

}
