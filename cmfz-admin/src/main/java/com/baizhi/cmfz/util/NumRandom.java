package com.baizhi.cmfz.util;

import java.util.Random;

public class NumRandom {
	/**
	 *
	 */
	public static String getRandom(int num){
		char[] chars="0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM".toCharArray();
		Random r=new Random();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<num;i++){
			sb.append(chars[r.nextInt(chars.length)]);
		}
		return sb.toString();
	}
}
