package Class019;

import java.io.*;
import java.util.Arrays;

public class Code03_StaticSpace {
    public static int MAXN = 201;
    public static int MAXM = 201;
    public static int[][] mat = new int[MAXN][MAXM];
    public static int[] arr = new int[MAXM];

    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    in.nextToken();
                    mat[i][j] = (int) in.nval;
                }
            }
            out.println(maxSumSubmatrix());
        }
        out.flush();
        br.close();
        out.close();
    }

    // 求子矩阵的最大累加和，后面的课会讲
    public static int maxSumSubmatrix() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // 因为之前的过程可能用过辅助数组
            // 为了让之前结果不干扰到这次运行，需要自己清空辅助数组需要用到的部分
            Arrays.fill(arr, 0, m, 0);
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[k] += mat[j][k];
                }
                max = Math.max(max, maxSumSubarray());
            }
        }
        return max;
    }

    // 求子数组的最大累加和，后面的课会讲
    public static int maxSumSubarray() {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < m; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
