import java.util.Random;
import java.util.Scanner;

public class QuickSort1 {

    // 使用临时变量交换数组中的两个元素
    static void arraySwap(int[] arr, int a, int b) {
        if(a != b)
        {
            arr[a] = arr[a] ^ arr[b];
            arr[b] = arr[a] ^ arr[b];
            arr[a] = arr[a] ^ arr[b];
        }
    }

    // 快速排序主逻辑
    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return; // 子数组长度为0或1时，直接返回
        }
        int i = left;
        int p1 = left - 1;
        int p2 = right + 1;
        int pivot = left + (int) (Math.random() * (right - left));

        while (i < p2) {
            if (arr[i] < pivot) {
                arraySwap(arr, i++, ++p1);
            } else if (arr[i] > pivot) {
                arraySwap(arr, i, --p2);
            } else {
                i++;
            }
        }

        quickSort(arr, left, p1);
        quickSort(arr, i, right);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("输入数组长度: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("输入数组元素: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 快速排序
        quickSort(arr, 0, n - 1);

        System.out.println("排序后的数组: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
