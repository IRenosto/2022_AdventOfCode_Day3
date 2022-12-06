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

			String line = br.readLine();
			int count, temp;
			String fCompart, sCompart;
			char shared = 0;
			int sum = 0;

			while (line != null) {
				count = (line.length()) / 2;
				fCompart = line.substring(0, count);
				sCompart = line.substring(count, count * 2);

				for (int i = 0; i < fCompart.length(); i++) {
					for (int j = 0; j < sCompart.length(); j++) {
						if (fCompart.split("")[i].equals(sCompart.split("")[j])) {
							shared = sCompart.charAt(j);
						}
					}
				}

				temp = shared - 96;
				if (temp < 0) {
					temp += 58;
				}

				sum += temp;

				line = br.readLine();
			}
			
			System.out.println("Sum of the priorities: " + sum);

		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

	}

}
