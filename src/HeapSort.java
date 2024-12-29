import java.util.Scanner;

public class HeapSort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(int[] arr, int n) {
//        for (int i = 0;i < n;i ++) {
//            heapInsert(arr, i);
//        }
        heapInsert_pro(arr, n);
        int heapSize = n;
        swap(arr, 0, --heapSize);
        while(heapSize > 0) {
            heapify(arr,0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index-1)/2]) {
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void heapInsert_pro(int[] arr, int n) {
        for (int i = n - 1;i >= 0;i--) {
            heapify(arr, i, n);
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;

        while(left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;

            if(largest == index) {
                break;
            }

            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        heapSort(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
