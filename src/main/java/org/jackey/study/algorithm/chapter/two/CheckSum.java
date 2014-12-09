package org.jackey.study.algorithm.chapter.two;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;
import org.jackey.kingbox.jtool.sort.ClassicSort;
import org.jackey.study.common.BaseArrayClass;

public class CheckSum extends BaseArrayClass {

	public static void checkSum(int[] array, int goal) {
		ClassicSort.quickSort(array);
		JOutPrint.JPrint(array);
		if (array[0] > goal) {
			JOutPrint.JPrint("No answer");
			return;
		}
		int length = array.length;
		int mid = goal / 2;
		int midIndex = BinarySearch.binarySearchIndex(array, goal, 0,
				array.length);
		JOutPrint.JPrint("midIndex=" + midIndex);
		for (int i = 0; i < midIndex; i++) {
			Integer index = BinarySearch.binarySearch(array, goal - array[i],
					midIndex, array.length);
			if (index != null) {
				JOutPrint.JPrint("[" + array[i] + "," + array[index] + "]");
			}
		}
	}

	public static void main(String[] args) {
		JOutPrint.JPrint(randomArray);
		checkSum(randomArray,50);
	}
}
