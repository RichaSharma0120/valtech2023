package com.valtech.training.day5;

import java.util.Arrays;
import java.util.List;

public class wordSort {
	
	public List<String> breakAndSort(String str){
		List<String> segments = Arrays.asList(str.split(" "));
		return segments;
		
	}

	public int countVowels(String[] splitString) {
		String vowels = "aeiou";
		int vowelCount=0;
		int consonents=0;
		float ratio;
		for(String s: splitString){

//			for(int j=0;j<s.length();j++) {
//				char letter = s.charAt(j);
//				if(vowels.indexOf(letter)==-1) {
//					consonents++;
//				}else {
//					vowelCount++;
//				}
//			}
		String word = s;
		for(int i=0; i<word.length(); i++) {
			if("aeiouAEIOU".contains(""+word.charAt(i)));
			vowelCount++;
		}

		}
		ratio = vowelCount / word.length();		
	}
	public static void main(String[] args) {
		
		String s = "Hello how are you";
		String[] split_string = s.split("\\s");	
//		List<String> segments = Arrays.asList(s.split(" "));
		for(int i=0;i<split_string.length-1;i++) {
			System.out.println(split_string[i]);
		}
		wordSort ws = new wordSort();
		ws.countVowels(split_string);
		
		
	}

}
