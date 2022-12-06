package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		// Challenge: https://adventofcode.com/2022/day/3

		File file = new File("input.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String first = br.readLine();
			String second, third;
			int temp;
			char shared = 0;
			int sum = 0;

			while (first != null) {

				second = br.readLine();
				third = br.readLine();

				for (int i = 0; i < first.length(); i++) {
					for (int j = 0; j < second.length(); j++) {
						for (int k = 0; k < third.length(); k++) {
							if (first.split("")[i].equals(second.split("")[j]) && second.split("")[j].equals(third.split("")[k])) {
								shared = third.charAt(k);
							}
						}
					}
				}

				temp = shared - 96;
				if (temp < 0) {
					temp += 58;
				}

				sum += temp;

				first = br.readLine();

			}

			System.out.println("Sum of the priorities: " + sum);

		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

	}

}
