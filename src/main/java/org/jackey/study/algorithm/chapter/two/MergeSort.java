package org.jackey.study.algorithm.chapter.two;

import java.util.Arrays;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;
import org.jackey.study.common.BaseArrayClass;

/**
 * @author jackey90.hj@gmail.com
 * @date Dec 11, 2014 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!! must be
 *       careful that, if mergeSort is [low,pivot] and [pivot+1,high] the merger
 *       must also be [low,pivot] and [pivot+1,high]
 *       !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Fucking important
 */
public class MergeSort extends BaseArrayClass {

	public static void merge(int[] array, int low, int high, int pivot) {
		if (low >= high) {
			return;
		}
		int[] left = Arrays.copyOfRange(array, low, pivot + 1);
		int[] right = Arrays.copyOfRange(array, pivot + 1, high + 1);
		int m = 0;
		int n = 0;
		int i = low;
		for (; i <= high; i++) {
			if (m >= left.length || n >= right.length) {
				break;
			}
			if (left[m] <= right[n]) {
				array[i] = left[m];
				m++;
			} else {
				int tempIndex = m;
				while (tempIndex < left.length) {
					JOutPrint.JPrint(left[tempIndex++] + " " + right[n]);
				}
				array[i] = right[n];
				n++;
			}
		}
		while (m < left.length) {
			array[i] = left[m];
			i++;
			m++;
		}
		while (n < right.length) {
			array[i] = right[n];
			i++;
			n++;
		}
	}

	public static void mergeSort(int[] array, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		mergeSort(array, low, mid);
		mergeSort(array, mid + 1, high);
		merge(array, low, high, mid);
	}

	public static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	public static void main(String[] args) {
		JOutPrint.JPrint(randomArray);
		mergeSort(randomArray);
		JOutPrint.JPrint(randomArray);
	}
}
