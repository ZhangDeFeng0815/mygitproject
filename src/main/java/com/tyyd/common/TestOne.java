package com.tyyd.common;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String ar = "a,b,c,,";
//		String[] arr = ar.split(",");
//		System.out.println(arr.length);
//		
//		
//		String[] str = new String[] { "you", "wu" }; 
//		List list1 = Arrays.asList(str);
//		
//		List<String> list = new ArrayList<String>();
//		list.add("2");
//		list.add("1");
//		for (String item : list) {
//			if ("1".equals(item)) {
//				list.remove(item);
//			}
//		}
		Instant is = Instant.now();
		System.out.println(Date.from(is).getTime());
		System.out.println(Date.from(is).getTime());
		Long s=1L;
		System.out.println(s>0);
	}

}
