package com.liuzhao.onroad.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {
	/**
	 * 判断是否为空
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isNullOrEmpty(String text) {
		if (text == null || "".equals(text.trim()) || text.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获得MD5加密字符串
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {

		} catch (UnsupportedEncodingException e) {

		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
}
