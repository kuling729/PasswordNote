package com.leo.utils;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class File3DES {
	private static String Algorithm = "DESede";

	public static byte[] encryptMode(String iv, String key, String src) {

		try {
			byte[] keyArray = new byte[24];
			byte[] keybyte = key.getBytes();
			if(keybyte.length>=24)
				System.arraycopy(keybyte, 0, keyArray, 0, 24);
			else
			{
				System.arraycopy(keybyte, 0, keyArray, 0, keybyte.length);
				for(int i = keybyte.length; i < 24; ++i)
				{
					keyArray[i] = 1;
				}
			}
			
			byte[] rand = new byte[8];
			rand = iv.getBytes();
			// 用随即数生成初始向量

			/*
			 * Random r=new Random(); r.nextBytes(rand);
			 */
			IvParameterSpec ivp = new IvParameterSpec(rand);

			// 生成密钥

			// SecureRandom sr = new SecureRandom();
			DESedeKeySpec dks = new DESedeKeySpec(keyArray);
			SecretKeyFactory keyFactory = SecretKeyFactory
					.getInstance("DESede");
			SecretKey securekey = keyFactory.generateSecret(dks);

			// 加密

			Cipher c1 = Cipher.getInstance(Algorithm + "/CBC/PKCS5Padding");

			c1.init(Cipher.ENCRYPT_MODE, securekey, ivp);

			return c1.doFinal(src.getBytes());// 在单一方面的加密或解密

		} catch (java.security.NoSuchAlgorithmException e1) {

			// TODO: handle exception

			e1.printStackTrace();

		} catch (javax.crypto.NoSuchPaddingException e2) {

			e2.printStackTrace();

		} catch (java.lang.Exception e3) {

			e3.printStackTrace();

		}

		return null;

	}

	public static byte[] decryptMode(String iv, String key, byte[] src) {

		try {
			
			byte[] keyArray = new byte[24];
			byte[] keybyte = key.getBytes();
			if(keybyte.length>=24)
				System.arraycopy(keybyte, 0, keyArray, 0, 24);
			else
			{
				System.arraycopy(keybyte, 0, keyArray, 0, keybyte.length);
				for(int i = keybyte.length; i < 24; ++i)
				{
					keyArray[i] = 1;
				}
			}
			byte[] srcbytes = src;
			byte[] rand = new byte[8];
			rand = iv.getBytes();
			// 用随即数生成初始向量

			/*
			 * Random r=new Random(); r.nextBytes(rand);
			 */
			IvParameterSpec ivp = new IvParameterSpec(rand);

			// 生成密钥

			SecureRandom sr = new SecureRandom();
			DESedeKeySpec dks = new DESedeKeySpec(keyArray);
			SecretKeyFactory keyFactory = SecretKeyFactory
					.getInstance("DESede");
			SecretKey securekey = keyFactory.generateSecret(dks);

			// 解密

			Cipher c1 = Cipher.getInstance(Algorithm + "/CBC/PKCS5Padding");

			c1.init(Cipher.DECRYPT_MODE, securekey, ivp);

			return c1.doFinal(srcbytes);

		} catch (java.security.NoSuchAlgorithmException e1) {

			// TODO: handle exception

			e1.printStackTrace();

		} catch (javax.crypto.NoSuchPaddingException e2) {

			e2.printStackTrace();

		} catch (java.lang.Exception e3) {

			e3.printStackTrace();

		}

		return null;

	}

//	public static final String encodeHex(byte bytes[]) {
//		StringBuffer buf = new StringBuffer(bytes.length * 2);
//		for (int i = 0; i < bytes.length; i++) {
//			if ((bytes[i] & 0xff) < 16)
//				buf.append("0");
//			buf.append(Long.toString(bytes[i] & 0xff, 16));
//		}
//		return buf.toString();
//	}

	

}
