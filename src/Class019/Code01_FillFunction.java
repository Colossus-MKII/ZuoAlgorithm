package Class019;


// test url: https://www.nowcoder.com/practice/840eee05dccd4ffd8f9433ce8085946b
public class Code01_FillFunction {
    public int sumOfSubMatrix(int[][] mat, int n) {
        return maxSumSubmatrix(mat, n, n);
    }

    public static int maxSumSubmatrix(int[][] mat, int n, int m) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int[] arr = new int[m];
            for (int j = i; j < n; ++j) {
                for (int k = 0; k < m; ++k) {
                    arr[k] += mat[j][k];
                }
                max = Math.max(max, maxSumSubarray(arr, m));
            }
        }
        return max;
    }

    public static int maxSumSubarray(int[] arr, int m) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < m; ++i) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
