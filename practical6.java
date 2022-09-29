// Linear Time Sort :Bucket Sort

import java.io.*;
import java.util.*;

class practical6 {
    public static void main(String[] args) {
        int[] numbers = { 12, 32, 11, 24, 33, 31, 01, 99, 15, 67 };
        ArrayList[] buckets = new ArrayList[10];
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int i : numbers) {
            buckets[i / 10].add(i);
        }

        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        for (ArrayList<Integer> bucket : buckets) {
            // System.out.println(bucket);
            for (int i = 0; i < bucket.size(); i++) {
                result.add(bucket.get(i));
            }
        }
        System.out.print(result);
    }
}