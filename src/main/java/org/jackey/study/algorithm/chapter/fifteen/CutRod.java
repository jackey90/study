package org.jackey.study.algorithm.chapter.fifteen;

import org.jackey.study.common.PublicData;

/**
 * Created by jackey90 on 2016/11/15.
 */
public class CutRod {

    public int cutRodRecursive(int[] price, int n) {
        if (n == 0)
            return 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxSum = Math.max(maxSum, price[i - 1] + cutRodRecursive(price, n - i));
        }
        return maxSum;
    }

    public int memorizedCutRod(int[] price, int n) {
        int[] mem = new int[n + 1];
        return memorizedCutRod(price, n, mem);
    }

    public int memorizedCutRod(int[] price, int n, int[] mem) {
        if (mem[n] > 0) {
            //System.out.println("men[" + n + "] = " + mem[n]);
            return mem[n];
        }
        if (n == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxSum = Math.max(maxSum, price[i - 1] + memorizedCutRod(price, n - i, mem));
        }
        mem[n] = maxSum;
        return maxSum;

    }

    public int bottomUpCutRod(int[] price, int n) {
        int[] mem = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxSum = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                maxSum = Math.max(maxSum, price[j - 1] + mem[i - j]);
            }
            mem[i] = maxSum;
        }
        return mem[n];
    }

    public static void main(String[] args) {
        int[] price = PublicData.randomGenerator(1,10000);
        long start = System.currentTimeMillis();
       // int[] price = {123,34,436,7,678,1, 345, 3, 6, 756, 5, 7234, 234, 5, 6, 457, 567, 32, 234, 234, 34, 46, 575, 8678, 678, 35, 35, 56, 8, 68, 123, 435, 45, 8, 9};
        System.out.println(price.length);
//        System.out.println(new CutRod().cutRodRecursive(price, 30));
//        System.out.println(System.currentTimeMillis() - start + " ms ");
//        start = System.currentTimeMillis();
//        System.out.println(new CutRod().memorizedCutRod(price, price.length));
//        System.out.println(System.currentTimeMillis() - start + " ms ");
//        start = System.currentTimeMillis();
        System.out.println(new CutRod().bottomUpCutRod(price, price.length));
        System.out.println(System.currentTimeMillis() - start + " ms ");
        start = System.currentTimeMillis();
    }
}

