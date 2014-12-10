package org.jackey.study.algorithm.chapter.two;

import java.util.Arrays;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;
import org.jackey.study.common.BaseArrayClass;

public class CheckSum extends BaseArrayClass {

	public static void checkSum(int[] array, int goal) {
		// Collections.sort(list);
		Arrays.sort(array);
		JOutPrint.JPrint(array);
		if (array[0] > goal) {
			JOutPrint.JPrint("No answer");
			return;
		}
		int length = array.length;
		int mid = goal / 2;
		int midIndex = BinarySearch.binarySearchIndex(array, mid, 0,
				array.length - 1);
		JOutPrint.JPrint("midIndex=" + midIndex);
		for (int i = 0; i < midIndex; i++) {
			Integer index = BinarySearch.binarySearch(array, goal - array[i],
					midIndex, array.length - 1);
			if (index != null) {
				JOutPrint.JPrint("[" + array[i] + "," + array[index] + "]");
			}
		}
	}

	public static void main(String[] args) {

		int[] array = { 49, 48, 3, 4, 5, 6, 1, 2, 33,47 };
		JOutPrint.JPrint(array);
		checkSum(array, 50);
	}
}
