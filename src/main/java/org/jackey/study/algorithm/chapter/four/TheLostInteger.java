package org.jackey.study.algorithm.chapter.four;

import java.util.Random;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;

public class TheLostInteger {
	private static int maxIndex = 100;
	private static Random r = new Random();
	static int[] arrayFull = new int[maxIndex];
	static int[] arrayLost = new int[maxIndex - 1];

	static {
		int lostIndex = r.nextInt(maxIndex - 1) + 1;

		for (int i = 0; i < maxIndex; i++) {
			arrayFull[i] = i;
			if (i > lostIndex) {
				arrayLost[i - 1] = i;
			} else {
				arrayLost[i] = i;
			}
		}
		JOutPrint.JPrint(arrayFull);
		System.out.println("Lost number :" + arrayFull[lostIndex]);
		JOutPrint.JPrint(arrayLost);
	}

	public static int foolFind() {
		return sum(arrayFull) - sum(arrayLost);
	}

	public static int sum(int[] array) {
		int result = -1;
		if (array != null) {
			result = 0;
			int index = 0;
			while (index < array.length) {
				result += array[index++];
			}
		}
		return result;
	}

	public static int binaryFind() {
		int result = -1;

		return result;
	}
	
	public static int count

	public static int countOneOrZero(int[] array, int[] oneArray, int[] zeroArray, int pos,
			int oneOrZero) {
		int count = 0;
		if (array != null && array.length > 0 && indexs != null
				&& indexs.length > 0) {

			for (int i = 0; i < indexs.length; i++) {
				if (getTheBitOf(array[indexs[i]], pos) == oneOrZero) {
					count++;
					indexs[count - 1] = i;
				}
			}
		}

		return count;
	}

	public static int getTheBitOf(int num, int pos) {
		return num >> pos & 1;
	}

	public static void main(String[] args) {
		JOutPrint.JPrint(foolFind());
		JOutPrint.JPrint(Integer.toBinaryString(123));
		JOutPrint.JPrint(Integer.bitCount(123));
		JOutPrint.JPrint(getTheBitOf(123, 2));
	}
}
