package sort;

import java.util.Random;

public class SortBasic {
    public static void printArr(int[] arr) {
        for (int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void isSort(String sort, int[] arr, boolean asc) {
        for (int i = 1; i < arr.length; i++) {
            if ((asc && arr[i] < arr[i - 1]) || (!asc && arr[i] > arr[i - 1])) {
                System.out.println(sort + ":array is not sort");
                return;
            }
        }
        System.out.println(sort + ":array is sort");
    }

    public static int[] randomArr(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }

}
