package org.jackey.study.algorithm.chapter.two;

import org.jackey.study.algorithm.chapter.common.PublicData;

public class InsertionSort {

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
		int[] array = PublicData.randomArray();
		improvedInsertSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
