package Class006;

import java.util.Arrays;

public class Code02_FindLeft {
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
            if (right(arr, num) != findLeft(arr, num)) {
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

    public static int right(int[] arr, int num) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] >= num) return i;
        }
        return -1;
    }

    public static int findLeft(int[] arr, int num) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
