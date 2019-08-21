package sort;

public class InsertTypeSort extends SortBasic {
    public static void main(String[] args) {
        int size = 10000;

        straightInsertSort(randomArr(size));

        binaryInsertSort(randomArr(size));

        shellSort(randomArr(size));

    }


    //1.直接插入排序
    public static void straightInsertSort(int[] arr) {
        int n = arr.length;
        int i = 1, j;
        for (; i < n; i++) {
            int cur = arr[i];
            for (j = i - 1; j >= 0 && cur < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = cur;
        }
        isSort("直接插入排序", arr, true);
    }


    //2.折半插入排序
    public static void binaryInsertSort(int[] arr) {
        int n = arr.length;
        int i = 1, j;
        for (; i < n; i++) {
            int v = arr[i];
            int low = 0, high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (v < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            for (j = i - 1; j > high; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = v;
        }
        isSort("折半插入排序", arr, true);
    }


    public static void shellSort(int[] arr) {
        int n = arr.length;
        int d = 5;//没有除1之外的公因子
        int i, j;
        while ((d /= 2) != 0) {
            for (i = d; i < n; i++) {
                int v = arr[i];
                for (j = i - d; j >= 0; j -= d) {
                    if (v < arr[j]) {
                        arr[j + d] = arr[j];
                    } else break;
                }
                arr[j + d] = v;
            }
        }

        isSort("希尔排序", arr, true);
    }


}
