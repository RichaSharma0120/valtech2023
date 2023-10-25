package com.valtech.training.day3;

import java.util.Random;

public class RandomGenerator {

	public int generateRandomNumber(int max, int min) {

		Random random = new Random();
		return random.nextInt(max - min + 1) + 18; // (61 - 18 + 1) + 18;
	}

public String generateRandomString() {


		String chars = "abcdefghijklmnopqrstuvwxyz";
		String firstletter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        int index = (int) (Math.random() * firstletter.length());
        sb.append(firstletter.charAt(index));

        int length = (int) (Math.random() * (10 - 3 + 1)) + 3;   //(10 - 3 + 1)) + 3;

        for (int i = 0; i < length; i++) {

            index = (int) (Math.random() * chars.length());

            sb.append(chars.charAt(index));

        }
        return sb.toString();

	}

}

