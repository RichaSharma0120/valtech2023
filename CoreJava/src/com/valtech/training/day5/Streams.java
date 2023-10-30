package com.valtech.training.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Collector;

//Collections
public class Streams {

	// this is how we used to do it earlier (without streams)
	private void traditional() {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> squares = new ArrayList<>();
		for (int i : nums) {
			squares.add(i * i);
		}
		System.out.println(nums);
		System.out.println(squares);
	}

	public static void main(String[] args) {
		Streams s = new Streams();
		s.traditional();

		// this is a new and efficient manner (sing streams). It allows us to iterate
		// over the list one-by-one
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> squares = nums.stream().map(i->i * i).collect(Collectors.toList());
//		List<Integer> sqrs = nums.stream().map(i->i*i).collect(Collectors.toList());
		List<Double> squareroot = nums.stream().map(i->Math.sqrt(i)).collect(Collectors.toList());
		List<Integer> add = nums.stream().filter(i->(i % 2) == i).collect(Collectors.toList());
		System.out.println(squares);
		System.out.println(squareroot);
		System.out.println(add);

	}
}
