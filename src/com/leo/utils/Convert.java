package com.leo.utils;

public class Convert {

	public static String convertBytesToString(byte[] data,int offset,int len){
		final String[] str=new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"}; 
		StringBuilder sb = new StringBuilder();
		byte tmp;
		for (int i=offset;i<offset+len;i++)
		{
			tmp=data[i];
			byte h=(byte)(tmp>>4);
			if (h<0)
				h=(byte)(16+h);
			byte l=(byte)(tmp&0x0F);
			if (l<0)
				l=(byte)(16+l);
			sb.append(str[h]);
			sb.append(str[l]);
			
		}
		return sb.toString();
	}
	
	public static byte[] convertStringToBytes(String str){
		if (str.length() % 2!=0)
			return null;
		
		char[] bs = str.toCharArray();
		byte[] result=new byte[(int)(bs.length /2)];
		byte r=0;
		for (int i=0;i<bs.length;i++){			
			switch (bs[i])
			{
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					r=(byte)((r<<4)|((bs[i]-'0')));
					break;
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
					r=(byte)((r<<4)|((bs[i]-'a')+0x0a));
					break;
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
					r=(byte)((r<<4)|(((bs[i]-'A')+0x0a)));
					break;
				default:
					return null;
			}
			if (i>0&&(i % 2!=0)){
				result[(int)(i/2)]=r;
				r=0;
			}
		}
		return result;
		
	}    
	
	public static byte[] hexStringToBytes(String hexString) {  
	    if (hexString == null || hexString.equals("")) {  
	        return null;  
	    }  
	    hexString = hexString.toUpperCase();  
	    int length = hexString.length() / 2;  
	    char[] hexChars = hexString.toCharArray();  
	    byte[] d = new byte[length];  
	    for (int i = 0; i < length; i++) {  
	        int pos = i * 2;  
	        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));  
	    }  
	    return d;  
	}
	
	private static byte charToByte(char c) {  
	    return (byte) "0123456789ABCDEF".indexOf(c);  
	}
}
