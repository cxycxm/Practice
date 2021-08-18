package com.leetcode.search;

public class BinarySearch {
    // 有序数组
    private int sortNums[] = {1,2,3,4,5,6,7};

    /**
     *  有序数组寻找目标值指针
     * @param target 目标值
     * @Retrun 目标值索引
     */
    public int binarySearch(int target){
        int start = 0;
        int end =  sortNums.length - 1;
        while (end >= start){
            int mid = (start + end)/2;
            if (sortNums[mid] == target){
                return mid;
            }else if (sortNums[mid] > target){
                end = mid - 1;
            }else if(sortNums[mid] < target){
                start = mid + 1;
            }
        }
      return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().binarySearch(9));
    }
}
