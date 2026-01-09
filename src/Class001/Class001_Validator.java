package Class001;

public class Class001_Validator {

    public static void main(String[] args) {
        int N = 200;
        int V = 1000;
        int testTimes = 50000;
        System.out.println("Test Start");
        for (int i = 0; i < testTimes; ++i) {
            int n = (int) (Math.random() * N);

            int[] arr = randomArray(n, V);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            selectionSort(arr1);
            bubbleSort(arr2);
            insertSort(arr3);
            if(!sameArray(arr1, arr2) || !sameArray(arr1, arr3)) {
                System.out.println("Error!");
            }
        }
        System.out.println("Test end!");
    }

    // For validate
    // n: the length of random array
    // every num in the array from (-v, v)
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];

        for (int i = 0; i < n; ++i) {
            int flag = (Math.random() < 0.5) ? 1 : -1;
            arr[i] = (int) (Math.random() * v) * flag;
        }
        return arr;
    }


    // copy array for validating
    public static int[] copyArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = arr[i];
        }
        return ans;
    }

    // validate
    public static boolean sameArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        for (int i = 0; i < n; ++i) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; ++i) {
            int minIndex = i;
            for (int j = i; j < arr.length; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int end = n - 1; end >= 0; --end) {
            boolean flag = false;
            for (int i = 0; i < end; ++i) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; --j) {
                swap(arr, j, j + 1);
            }
        }
    }

}
