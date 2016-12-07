package org.jackey.study.algorithm.chapter.sixteen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackey90 on 2016/12/7.
 */
public class ActivitySelector {


    public List<Integer> recursiveActivitySelector(int[] s, int[] f){
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        recursiveActivitySelector(s,f,1,s.length - 1,list);
        return list;
    }


    private void recursiveActivitySelector(int[] s, int[] f, int m, int n, List<Integer> list){
        int k = m;
        while(m <= n && f[k] > s[m]){
            m = m + 1;
        }
        if(m <= n){
            list.add(m);
            recursiveActivitySelector(s,f,m,n,list);
        }else{
            return;
        }
    }


    public static void main(String[] args) {
        int[] s = {1,3,0,5,3,5,6,8,8,2,12};
        int[] f = {4,5,6,7,9,9,10,11,12,14,16};
        System.out.println(new ActivitySelector().recursiveActivitySelector(s,f));

    }
}
