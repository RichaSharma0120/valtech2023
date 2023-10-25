package com.valtech.training.day5;

import java.util.Arrays;
import java.util.List;

public class AscendingDescendingArray {
	
	public static boolean isAscendingDescending(int[] arr) {
		
		boolean isAscending = false;
		boolean isDescending = false;
		for (int i = 1; i < arr.length; i++) {
			int diff = arr[i] - arr[i - 1];
			if (diff >0) {
				if (isDescending != false) {
					isDescending = false;
				}
					isAscending = true;
			} else if (diff <0) {
				if (isDescending != true) {
					isDescending = true;
				}
			}
		}
		return (isAscending && isDescending)? true:false;
    }


	public static void main(String[] args) {
		
		int[] arr1 = {4,5,8,6,1,9,2,10,3};
//        int[] arr2 = {5,4,3,2,1};
//        int[] arr3 = {4,5, 3, 2, 1};

        System.out.println("arr1 is ascending-descending: " + isAscendingDescending(arr1));
//        System.out.println("arr2 is ascending-descending: " + isAscendingDescending(arr2));
//        System.out.println("arr3 is ascending-descending: " + isAscendingDescending(arr3));
		
	}

}
