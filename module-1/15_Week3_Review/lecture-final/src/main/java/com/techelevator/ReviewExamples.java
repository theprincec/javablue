package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReviewExamples {

	public static void main(String[] args) {
		
		// Array to List for reference type
		String[] strs = {"abc", "xyz", "123"};
		List<String> strList = Arrays.asList(strs);
		
		// Array to List for primitive type
		int[] nums = { 10, 20, 30 };	
		List<Integer> listNums = new ArrayList<Integer>();
		for (int n : nums) {
			listNums.add(n);
		}
		
		// List to Array
		String[] backToStrArray = strList.toArray( new String[strList.size()]);
		Integer[] toIntArray = listNums.toArray( new Integer[ listNums.size()] );
		

	}

}
