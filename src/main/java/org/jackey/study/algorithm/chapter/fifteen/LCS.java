package org.jackey.study.algorithm.chapter.fifteen;

/**
 * Created by jackey90 on 2016/11/22.
 * longest common subsequence
 */
public class LCS {
    public int lcsLength(String str1, String str2){
        if(str1.length() == 0 || str2.length() == 0){
            return 0;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int[][] l = new int[arr1.length + 1][arr2.length + 1];
        for(int i = 1; i <= arr1.length; i++){
            for(int j = 1; j <= arr2.length; j++){
                if(arr1[i -1 ] == arr2[j - 1]){
                    l[i][j] = l[i - 1][j -1] + 1;
                }else{
                    l[i][j] = Math.max(l[i - 1][j], l[i][j -1]);
                }
            }
        }

        return l[arr1.length][arr2.length];
    }

    public static void main(String[] args) {
        System.out.println(new LCS().lcsLength("12458","2468"));
    }
}
