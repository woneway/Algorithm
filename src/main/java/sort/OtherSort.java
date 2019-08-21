package sort;

public class OtherSort extends SortBasic {
    //1.归并排序
    public static void main(String[] args) {
        mergeSort(randomArr(10000));
    }


    public static void mergeSort(int[] arr) {
        splitArr(arr, 0, arr.length - 1);
        isSort("归并排序", arr, true);
    }

    private static void splitArr(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            splitArr(arr, low, mid);
            splitArr(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int j;
        for (int i = mid + 1; i <= high; i++) {
            int cur = arr[i];
            for (j = i - 1; j >= low && arr[j] > cur; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = cur;
        }
    }

}
