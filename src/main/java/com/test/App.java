package com.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConcurrentHashMap map = new ConcurrentHashMap<>();
        map.put("name", "zhangsan");
        map.put("name", "zhangsan");
        map.put("name", "zhangsan");

        HashMap hashMap = new HashMap();
        hashMap.put("age", 10);

        App app = new App(1000);
        app.print();
//        app.popo();
        app.quick(0, app.arrays.length - 1);
        app.print();


    }

    public int[] arrays ;
    public App(int size) {
        arrays = new int[size];
        for (int i = 0; i < size; i++) {
            arrays[i] = (int) (Math.random() * size);
        }
    }
    public void popo() {
        for (int i = 0; i < arrays.length; i++) {
            for (int j =0; j < arrays.length - i - 1; j++) {
                if (arrays[j] > arrays[j+1]) {
                    int tmp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = tmp;
                }
            }
        }
    }
    public void quick(int begin, int end) {
        int i = begin;
        int j = end;
        boolean flag = true;
        if (i >= j) {
            return;
        }
        while (i != j) {
            if (arrays[i] < arrays[j]) {
                int temp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = temp;
                flag = !flag;
            }
            if (flag) {
                j--;
            } else {
                i++;
            }
        }
        j++;
        i--;
        quick(begin, i);
        quick(j, end);
    }
    public void print() {
        for (int num : arrays) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

}
