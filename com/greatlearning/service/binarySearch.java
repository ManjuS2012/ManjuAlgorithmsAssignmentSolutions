package com.greatlearning.service;

/**
 * TODO: Binary search on top of descending order array
 *
 * @author manju
 *
 */
public class binarySearch {

    public static int binarySearch(double arr[], int l, int r, double x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle itself

            if (arr[mid] == x)
                return mid;

            // If element is greater than mid, then
            // it can only be present in left subarray - array passed as
            // descending order
            if (arr[mid] < x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present in right subarray

            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }

}
