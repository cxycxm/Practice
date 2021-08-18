package com.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] nums3 = new int[m + n];
            int  k = 0, j = 0;
            while(j < m || k < n){
                if(j < m && nums1[j] <= nums2[k]){
                    nums3[j+k] = nums1[j];
                    j++;
                }else if (k < n){
                    nums3[j+k] = nums2[k];
                    k++;
                }
            }
            for(int s = 0; s < nums1.length; s++){
                nums1[s] = nums3[s];
            }
        }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public static boolean isSymmetric(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            mid(root, list);
            int size = list.size();
            int[] s = new int[size];
            for(int i = 0; i < size; i++){
                s[i] = list.get(i);
            }
            int min = 0;
            int max = size - 1;
            while(min < max){
                if(s[min] != s[max])
                    return false;
                min++;
                max--;
            }
            return true;
        }

        public static void mid(TreeNode root, List<Integer> list){
            if(root != null)
                return;
            mid(root.left, list);
            list.add(root.val);
            mid(root.right, list);
        }

    public static void main(String[] args) {
       int left = 2, right = 4;
       int mid = left + (right - left) / 2;
       System.out.println(mid);
    }
}
