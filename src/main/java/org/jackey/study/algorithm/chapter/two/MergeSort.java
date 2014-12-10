package org.jackey.study.algorithm.chapter.two;

import java.util.Arrays;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;
import org.jackey.study.common.BaseArrayClass;

public class MergeSort extends BaseArrayClass {
	public static void merge(int[] array, int low, int high, int pivot) {
		int[] left = Arrays.copyOfRange(array, low, pivot + 1);
		int[] right = Arrays.copyOfRange(array, pivot, high + 1);
		int m = 0;
		int n = 0;
		int i = low;
		for (; i <= high; i++) {
			if (m >= left.length) {
				array[i] = right[n];
				n++;
				continue;
			}
			if (n >= right.length) {
				array[i] = left[m];
				m++;
				continue;
			}
			if (left[m] < right[n]) {
				array[i] = left[m];
				m++;
			} else {
				array[i] = right[n];
				n++;
			}
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
