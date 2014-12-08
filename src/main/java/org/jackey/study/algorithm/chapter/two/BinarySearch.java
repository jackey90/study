package org.jackey.study.algorithm.chapter.two;

import org.jackey.study.algorithm.chapter.common.PublicData;

public class BinarySearch {

	/**
	 * @param array
	 *            a sorted array , from min to max
	 * @param goal
	 *            what number to find
	 * @param low
	 *            low index
	 * @param high
	 *            high index
	 * @return the index of goal in array, if array do not contains goal ,
	 *         return nil
	 */
	public static Integer binarySearch(int[] array, int goal, int low, int high) {
		if (array == null || low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		if (goal == array[mid]) {
			return mid;
		}
		if (goal > array[mid]) {
			return binarySearch(array, goal, mid + 1, high);
		} else {
			return binarySearch(array, goal, low, mid - 1);
		}
	}

	/**
	 * @param array
	 *            a sorted array , from min to max
	 * @param goal
	 *            what number to find
	 * @param low
	 *            low index
	 * @param high
	 *            high index
	 * @return the right place of goal in the array.
	 */
	public static Integer binarySearchIndex(int[] array, int goal, int low,
			int high) {
		if (array == null) {
			return null;
		}
		if (low > high) {
			return low;
		}
		int mid = (low + high) / 2;
		if (goal == array[mid]) {
			return mid;
		}
		if (goal > array[mid]) {
			return binarySearchIndex(array, goal, mid + 1, high);
		} else {
			return binarySearchIndex(array, goal, low, mid - 1);
		}

	}

	public static void main(String[] args) {
		int[] array = PublicData.sortedArray();
		int goal = 50;
		System.out.println(binarySearch(array, goal, 0, array.length - 1));
		System.out.println(binarySearchIndex(array, goal, 0, array.length - 1));
	}

}
