package sort;

/**
 * 交换排序
 */
public class ExchangeTypeSort extends SortBasic {
    public static void main(String[] args) {
        int size = 10000;
        bubbleSort(randomArr(size));
        quickSort(randomArr(size));
    }

    //1.冒泡排序
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n && !flag; i++) {
            flag = true;
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    flag = false;
                }
            }
        }
        isSort("冒泡排序", arr, true);
    }


    //2.快速排序
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        isSort("快速排序", arr, true);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int midV = arr[low];
        while (low < high) {
            while (low < high && arr[low] <= midV) ++low;
            while (low < high && arr[high] >= midV) --high;
            swap(arr, low, high);
        }
        arr[low] = midV;
        return low;
    }
}
