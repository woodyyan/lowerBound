package com.lowerbound;

public class Application {

    public static void main(String[] args) {
        int srcArray[] = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
        System.out.println(lower_bound(srcArray, 0, srcArray.length - 1, 80));
        System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 81));
    }

    // 二分查找递归实现
    public static int binSearch(int srcArray[], int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }

    // 查找顺序数组里面第一个大于等于target的数的下标
    public static int lower_bound(int arr[], int start, int end, int target) {
        int middle = (end - start) / 2 + start;
        if (arr[middle] == target) {
            return middle;
        } else if (end - start == 1) {
            return arr[start] >= target ? start : end;
        }

        if (arr[middle] >= target) {
            return lower_bound(arr, start, middle, target);
        } else {
            return lower_bound(arr, middle + 1, end, target);
        }
    }
}
