package Class002;

import java.util.Arrays;

public class Code01_FindNumber {
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 500000;
        System.out.println("Test Start");
        for (int i = 0; i < testTime; ++i) {
            int n = (int) (Math.random() * N);
            int[] arr = randomArray(n, V);
            Arrays.sort(arr);
            int num = (int) (Math.random() * V);
            if (right(arr, num) != exist(arr, num)) {
                System.out.println("Error!");
            }
        }
        System.out.println("Test End");
    }

    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            int flag = (Math.random() < 0.5) ? 1 : -1;
            arr[i] = (int) (Math.random() * v) * flag;
        }
        return arr;
    }


    // For validation
    public static boolean right(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean exist(int[] arr, int num) {
        if (arr == null && arr.length == 0) {
            return false;
        }
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
