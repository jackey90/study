package org.jackey.study.algorithm.chapter.two;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;
import org.jackey.study.common.BaseArrayClass;
import org.jackey.study.common.PublicData;

/**
 * @author jackey90.hj@gmail.com
 * @date Dec 9, 2014
 *
 *       Observe that the while loop of lines 5–7 of the INSERTION-SORT
 *       procedure in Section 2.1 uses a linear search to scan (backward)
 *       through the sorted subarray AOE1 : : j  1. Can we use a binary search
 *       (see Exercise 2.3-5) instead to improve the overall worst-case running
 *       time of insertion sort to ‚O(nlgn)
 */
public class InsertionSort extends BaseArrayClass {

	public static void improvedInsertSort(int[] array) {
		if (array == null) {
			return;
		}
		int length = array.length;
		int index;
		for (int i = 1; i < length; i++) {
			int goal = array[i];
			index = BinarySearch.binarySearchIndex(array, goal, 0, i - 1);
			int j = i - 1;
			for (; j >= index; j--) {
				array[j + 1] = array[j];
			}
			array[index] = goal;
		}

	}

	public static void main(String[] args) {
		JOutPrint.JPrint(randomArray);
		improvedInsertSort(randomArray);
		JOutPrint.JPrint(randomArray);
	}
}
