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
		int length = arrayFull.length;
		int maxPos = Integer.bitCount(arrayFull[length - 1]);
		int[] ones = new int[length];
		int[] zeros = new int[length];
		int[] indexs = new int[length];
		for (int i = 0; i < length; i++) {
			indexs[i] = i;
		}
		int count = length;
		for (int i = maxPos; i >= 0; i--) {
			count = countOneAndZero(indexs, ones, zeros, i, count);
			if (count == 0) {
				result = arrayFull[indexs[0]];
			}
		}

		return result;
	}

	public static int countOneAndZero(int[] indexs, int[] ones, int[] zeros,
			int pos, int count) {

		int one = 0;
		int zero = 0;
		int lostZero = 0;
		int num1;
		int num2;
		for (int i = count - 1; i >= 0; i--) {
			num1 = arrayFull[indexs[i]];
			JOutPrint.JPrint(Integer.toBinaryString(num1));
			if (getTheBitOf(num1, pos) == 0) {
				zero++;
				zeros[zero - 1] = i;
			} else {
				ones[one++] = i;
			}

			if (i < count - 1) {
				num2 = arrayLost[indexs[i]];
				JOutPrint.JPrint(Integer.toBinaryString(num2));
				if (getTheBitOf(num2, pos) == 0) {
					lostZero++;
				}
			}
		}

		if (zero == lostZero) {
			indexs = ones;
			return one - 1;
		} else {
			indexs = zeros;
			return zero - 1;
		}

	}

	public static int getTheBitOf(int num, int pos) {
		return num >> pos & 1;
	}

	public static void main(String[] args) {
		// JOutPrint.JPrint(foolFind());
		JOutPrint.JPrint(binaryFind());
	}
}
