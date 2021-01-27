package com.sin.buildingInsights.data.repository;

import java.util.Arrays;

/**
 * 1. Traverse each element of array .
 * 2. If arr[i] <= prev then update prev by adding 1 and update sum by adding prev,
 * else update prev by cur element and update sum by adding cur element(arr[i]).
 * 3. After traversing of each element return sum
 * Complexity: O(n)
 */
public class Assessment19 {

    //arr = [4, 1, 2, 2]
    public int findMinSum(int elements[]) {

        // sort array first
        Arrays.sort(elements);

        int sum = elements[0], prev = elements[0];
        int size = elements.length;

        for (int i = 1; i < size; i++) {
            if (elements[i] <= prev) {
                prev = prev + 1;
                sum = sum + prev;
            } else {
                sum = sum + elements[i];
                prev = elements[i];
            }
        }

        return sum;
    }
}
