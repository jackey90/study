package org.jackey.study.algorithm.chapter.five;

import java.util.Arrays;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;
import org.jackey.study.common.BaseArrayClass;

public class HeapSort extends BaseArrayClass {

	public static void maxHeaplify(int[] array, int i, int heapSize) {
		maxHeaplifyRecursive(array, i,heapSize);
	}

	public static void maxHeaplifyRecursive(int[] array, int i, int heapSize) {
		int left = left(i);
		int right = right(i);

		int largest = i;

		if (left < heapSize && array[left] > array[i]) {
			largest = left;
		}
		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(array, largest, i);
			maxHeaplifyRecursive(array, largest,heapSize);
		}

	}

	public static void maxHeaplifyIterator(int[] array, int i, int heapSize) {

		while (i < heapSize) {
			int left = left(i);
			int right = right(i);
			int largest = i;

			if (left < heapSize && array[left] > array[i]) {
				largest = left;
			}
			if (right < heapSize && array[right] > array[largest]) {
				largest = right;
			}

			if (largest != i) {
				swap(array, largest, i);
				i = largest;
			} else {
				break;
			}

		}
	}

	public static void buildMaxHeap(int[] array) {
		int mid = array.length / 2 + 1;
		while (mid-- > 1) {
			maxHeaplify(array, mid,array.length);
		}
	}

	public static int left(int i) {
		return i << 1;
	}

	public static int right(int i) {
		return (i << 1) + 1;
	}
	
	public static void heapSort(int[] array){
		buildMaxHeap(array);
		int length = array.length;
		int heapSize = array.length;
		while(length-- > 2){
			swap(array,1,length);
			heapSize--;
			maxHeaplify(array, 1,heapSize);
		}
	}

	public static void main(String[] args) {
		Arrays.fill(randomArray, 0, 1, 0);
		JOutPrint.JPrint(randomArray);

		//maxHeaplify(randomArray, 1);

		heapSort(randomArray);
		JOutPrint.JPrint(randomArray);
	}
}
