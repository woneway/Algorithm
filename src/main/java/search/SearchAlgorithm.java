package search;

public class SearchAlgorithm {

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] tree = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] w = {1, 1, 2, 5, 3, 4, 4, 3, 5};
        System.out.println(binarySearch(test, 7));
        staticSecondOptimalSearch(tree, w);
    }

    //1.折半查找
    public static int binarySearch(int[] arr, int v) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == v) return mid;
            if (v > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    //构建次优静态树
    public static BinaryTree staticSecondOptimalSearch(int[] arr, int[] w) {
        int len = arr.length;
        int[] sw = new int[len + 1];
        sw[0] = 0;
        for (int i = 1; i <= len; i++) {
            sw[i] = sw[i - 1] + w[i - 1];
        }
        return staticSecondOptimalSearch(arr, sw, 0, len - 1);
    }

    private static BinaryTree staticSecondOptimalSearch(int[] arr, int[] sw, int low, int high) {
        int dw = sw[low] + sw[high + 1];
        //delta(p) = |dw - sw[p+1] - sw[p]|;
        int i = low, min = Integer.MAX_VALUE, minI = low;
        for (; i <= high; i++) {
            if (Math.abs(dw - sw[i + 1] - sw[i]) < min) {
                minI = i;
                min = Math.abs(dw - sw[i + 1] - sw[i]);
            }
        }
        BinaryTree tree = new BinaryTree();
        tree.data = arr[minI];
        if (low < minI) {
            tree.lchild = staticSecondOptimalSearch(arr, sw, low, minI - 1);
        }
        if (high > minI) {
            tree.rchild = staticSecondOptimalSearch(arr, sw, minI + 1, high);
        }
        return tree;
    }


    static class BinaryTree {
        int data;
        BinaryTree lchild;
        BinaryTree rchild;

        public BinaryTree() {
        }
    }
}
