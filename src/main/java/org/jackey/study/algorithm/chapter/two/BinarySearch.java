package org.jackey.study.algorithm.chapter.two;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;
import org.jackey.study.common.BaseArrayClass;
import org.jackey.study.common.PublicData;

/**
 * @author jackey90.hj@gmail.com
 *
 *         Referring back to the searching problem (see Exercise 2.1-3), observe
 *         that if the sequence A is sorted, we can check the midpoint of the
 *         sequence against  and eliminate half of the sequence from further
 *         consideration. The binary search algorithm repeats this procedure,
 *         halving the size of the remaining portion of the sequence each time.
 *         Write pseudocode, either iterative or recursive, for binary search.
 *         Argue that the worst-case running time of binary search is ‚.lg n/.
 */
public class BinarySearch extends BaseArrayClass{

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
		int goal = 50;
		JOutPrint.JPrint(sortedArray);
		JOutPrint.JPrint(binarySearch(sortedArray, goal, 0, sortedArray.length - 1));
		JOutPrint.JPrint(binarySearchIndex(sortedArray, goal, 0, sortedArray.length - 1));
	}

}
