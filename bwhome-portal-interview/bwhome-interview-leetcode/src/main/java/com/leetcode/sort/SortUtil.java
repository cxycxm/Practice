package com.leetcode.sort;

import java.util.Arrays;

/**
 * 从小到大排序：插入排序，冒泡排序，选择排序，希尔排序，快速排序
 */
public class SortUtil {

    // 定义数组
    private int[] nums = {5,4,2,3,1};
    /**
     *  插入排序。思路：最前面始终有序，每次外层循环新往有序数组插入一个元素。内层循环将所有大于该元素的数进行后移。
     */
    public int[] insertSort(){
        // 外层循环：作用是将预定义的指针后移一位获取最新要插入的元素，并在内层循环元素移动完成后，将该元素插入到对应位置
        // 内层循环，比较将大于即将插入的元素的所有元素后移，并且找到新元素要插入的位置
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i];
            int j;
            // 注意数组越界
            for (j = i - 1; j > -1  && temp < nums[j] ; j--){
                nums[j + 1] = nums[j];
            }
            nums[j+1] = temp;
        }
        return nums;
    }

    /**
     * 冒泡排序。思路：相邻元素不断比较交换位置。两层循环。内层循环：循环体进行前后元素比较换位，循环条件进行指针移动和循环退出；外层循环退出
     * @return 从小到大排序的数组
     */
    public int[] bubbleSort(){
        // 外层循环：作用是进行数组长度次的循环
        // 内层循环：前后元素进行比较交换，指针移动且进行数组长度-外层循环次的循环
        // 进行优化：如果某次比较未进行元素交换，说明此时数组已经有序，不需要继续进行比较。实现：通过falg，外层循环记录，内层循环修改
        boolean flag = true; // 无序为true
        for (int i = 0; i < nums.length && flag; i++){
            // 注意数组越界
            for (int j = 0; j < nums.length - i - 1; j++){
                flag = false;
                if (nums[j] > nums[j+1]){
                    swap(j,j+1);
                    flag = true;
                }
            }
        }
        return nums;
    }

    /**
     * 选择排序。思路：每次找到当前最小元素下标之后在进行交换。内层循环：找到当前最小元素下标，进行交换。外层循环，进行指针移动，并且执行数组长度次循环。
     * @return 从小到大排序的数组
     */
    public int[] selectionSort(){
        // 内层循环：循环体，默认当前指针为最小元素下标，用该下标指向的元素与后面的元素不断比较，直到数组末尾，找到最小值的下标，然后进行交换
        // 外层循环：指针向后移动一位，执行数组长度次循环
        for (int i = 0; i< nums.length; i++){
            int min = i;
            for (int j = i; j < nums.length; j++){
                if (nums[min] > nums[j]){
                    min = j;
                }
            }
            swap(i , min);
        }
        return nums;
    }
    /**
     *  数组元素交换顺序
     * @param a
     * @param b
     */
    private void swap(int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     *  快速排序。思路：把小于基准数的元素全部放到基准数左边，大于基准数的元素放在基准数右边，找到基准数下标进行递归，重复以上工作
     * @return 从小到大排序的有序数组
     */
    public int[] quickSort(int start, int end){
        if (end > start){
            int target = quick(start, end);
            quickSort(start, target - 1);
            quickSort(target + 1, end);
        }
        return nums;
    }

    /**
     *  填坑法把小于基准的数放在基准左边，大于基准的数放在基准右边，同时找到基准指针位置
     * @param i
     * @param j
     * @Return 基准指针
     */
    private int quick(int i, int j){
        // 默认i位置的值为基准
        int tmp = nums[i]; // 此时i挖坑
        while (i < j){
            // 从j开始向左找比基准小的数，填到基准的坑
            while(i < j && nums[j] > tmp){
                j--;
            }
            if (j > i){
                nums[i] = nums[j];
                i++;
            }
            while(j > i && nums[i] < tmp){
                i++;
            }
            if (j > i){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = tmp;
        return i;
    }
    void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }
    public static void main(String[] args) {
        SortUtil sortUtil = new SortUtil();
        Arrays.stream(sortUtil.quickSort(0 ,sortUtil.nums.length-1)).forEach(item->
                System.out.print(item)
        );
    }
}
