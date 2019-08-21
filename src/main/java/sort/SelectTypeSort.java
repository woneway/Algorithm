package sort;

public class SelectTypeSort extends SortBasic {

    public static void main(String[] args) {
        easySelectSort(randomArr(1000));
        heapSort(randomArr(1000));

    }

    //1.简单选择排序
    public static void easySelectSort(int[] arr) {
        int n = arr.length;
        int maxIndex;
        for (int i = n - 1; i > 0; i--) {
            maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(arr, maxIndex, i);
        }
        isSort("简单选择排序：", arr, true);
    }


    //2.堆排序
    public static void heapSort(int[] arr) {
        int n = arr.length;
        while (--n > 0) {
            heapSort(arr, n);
            swap(arr, 0, n);
        }
        isSort("堆排序", arr, true);
    }

    private static void heapSort(int[] arr, int n) {
        for (int p = n / 2; p >= 0; p--) {
            int child = p * 2;
            if (child < n && arr[child] < arr[child + 1]) ++child;
            if (arr[child] > arr[p]) {
                swap(arr, child, p);
            }
        }
    }
}
