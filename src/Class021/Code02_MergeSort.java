package Class021;

// 测试链接 : https://leetcode.cn/problems/sort-an-array/

import java.awt.font.NumericShaper;
import java.awt.image.ImageFilter;
import java.util.Arrays;

public class Code02_MergeSort {
    public int[] sortArray(int[] nums) {
        if (nums.length > 1) {
//            mergeSort1(nums);
            mergeSort2(nums);
        }
        return nums;
    }

    public static int MAXN = 50001;
    public static int[] help = new int[MAXN];

    public void mergeSort1(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        sort(nums, l, m);
        sort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    public static void mergeSort2(int[] nums) {
        int n = nums.length;
        for (int l, m, r, step = 1; step < n; step <<= 1) {
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n) {
                    break;
                }
                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(nums, l, m, r);
                l = r + 1;
            }
        }
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int k = l;
        while (i <= m && j <= r) {
            help[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= m) {
            help[k++] = nums[i++];
        }
        while (j <= r) {
            help[k++] = nums[j++];
        }
        for (i = l; i <= r; ++i) {
            nums[i] = help[i];
        }
    }
}
