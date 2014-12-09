package org.jackey.study.common;

public class BaseArrayClass {
	protected static int[] sortedArray;
	protected static int[] randomArray;
	
	static {
		sortedArray = PublicData.sortedArray();
		randomArray = PublicData.randomArray();
	}
}
