package org.jackey.study.algorithm.chapter.four;

import java.util.Random;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;

public class TheLostInteger {
	private static int maxIndex = 20;
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
		int maxPos = Integer.toBinaryString(arrayFull[length - 1]).length() - 1;
		int[] ones = new int[length];
		int[] zeros = new int[length];
		int index = 0;
		// for (int i = length - 1; i >= 0; i--) {
		// ones[index++] = i;
		// }

		for (int i = 0; i < length; i++) {
			ones[i] = i;
		}

		int count = length;
		boolean isOne = true;
		// for (int i = maxPos; i >= 0; i--) {
		// count = countOneAndZero(ones, zeros, i, count, isOne);
		// if (count == 0) {
		// if (isOne) {
		// result = arrayFull[ones[0]];
		// } else {
		// result = arrayFull[zeros[0]];
		// }
		// break;
		// }
		// }

		result = countOneAndZero(ones, zeros, maxPos, count, count - 1, isOne);

		return result;
	}

	public static int countOneAndZero(int[] ones, int[] zeros, int pos,
			int fullCount, int lostCount, boolean isOne) {
		if (pos < 0 || fullCount <= 0) {
			if (isOne) {
				return arrayFull[ones[0]];
			} else {
				return arrayFull[zeros[0]];
			}
		}

		int one = 0;
		int zero = 0;
		int lostZero = 0;
		int lostOne = 0;
		int num1;
		int num2;
		int[] indexs;
		if (isOne) {
			indexs = ones;
		} else {
			indexs = zeros;
		}

		int index;
		for (int i = 0; i < fullCount; i++) {
			index = indexs[i];
			num1 = arrayFull[index];
			JOutPrint.JPrint(Integer.toBinaryString(num1) + " num1  pos " + pos
					+ "    " + num1);
			if (getTheBitOf(num1, pos) == 0) {
				zero++;
				zeros[zero - 1] = index;
			} else {
				ones[one++] = index;
			}

			if (i < lostCount) {
				num2 = arrayLost[index];
				JOutPrint.JPrint(Integer.toBinaryString(num2) + " num2 pos "
						+ pos + "    " + num2);
				if (getTheBitOf(num2, pos) == 0) {
					lostZero++;
				} else {
					lostOne++;
				}
			}
		}

		if (zero == lostZero) {
			JOutPrint.JPrint("one " + one);
			isOne = true;
			return countOneAndZero(ones, zeros, pos - 1, one , lostOne ,
					isOne);
		} else {
			JOutPrint.JPrint("zero " + zero);
			isOne = false;
			return countOneAndZero(ones, zeros, pos - 1, zero ,
					lostZero , isOne);
		}

	}

	public static int getTheBitOf(int num, int pos) {
		return num >> pos & 1;
	}

	public static void main(String[] args) {
		// JOutPrint.JPrint(foolFind());
		//JOutPrint.JPrint(binaryFind());
		JOutPrint.JPrint(binaryFind());
		
	}
}
