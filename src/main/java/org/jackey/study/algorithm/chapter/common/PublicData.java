package org.jackey.study.algorithm.chapter.common;

import java.util.Random;

public class PublicData {
	private static int BEGIN = 1;
	private static int LENGTH = 20;
	private static int SEED = 50;

	private static Random r = new Random();

	public static int[] generator(int begin, int length, boolean sorted,
			boolean conti) {
		int[] result = new int[length];
		if (conti) {
			for (int i = 0; i < length; i++) {
				result[i] = begin;
				begin++;
			}
		} else {

			for (int i = 0; i < length; i++) {
				result[i] = begin;
				begin += r.nextInt(SEED) + 1;
			}

			if (!sorted) {
				
				for (int i = 0; i < length; i++) {
					// System.out.print("[" + i + " : " + result[i] + "]");
					System.out.print(result[i] + "    ");
				}
				System.out.println();

				for (int i = 0; i < length; i++) {
					swap(result, i, r.nextInt(length));
				}
			}

		}
		for (int i = 0; i < length; i++) {
			// System.out.print("[" + i + " : " + result[i] + "]");
			System.out.print(result[i] + "    ");
		}
		System.out.println();
		return result;
	}

	public static void swap(int[] result, int i, int j) {
		int temp = result[i];
		result[i] = result[j];
		result[j] = temp;
	}

	public static int[] sortedGenerator(int begin, int length) {
		return generator(begin, length, true, false);
	}

	public static int[] sortedArray() {
		return sortedGenerator(BEGIN, LENGTH);
	}

	public static int[] randomGenerator(int begin, int length) {
		return generator(begin, length, false, false);
	}

	public static int[] randomArray() {
		return randomGenerator(BEGIN, LENGTH);
	}
}
