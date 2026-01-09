package Class006;

public class Code04_FindPeakElement {
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }

        int left = 1, right = n - 2;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else if (arr[mid] < arr[mid + 1]){
                left = mid + 1;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
}
