import java.util.Scanner;

public class QuickSort {

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

        // 分区操作
        int pivotIndex = partition(arr, left, right);

        // 递归排序左、右子数组
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    // 分区方法
    static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 选择最右边的元素作为基准值
        int i = left - 1;       // i 指向小于 pivot 的最后一个元素

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                arraySwap(arr, i, j); // 将小于 pivot 的元素交换到左侧
            }
        }

        // 将基准值 pivot 放到正确的位置
        arraySwap(arr, i + 1, right);
        return i + 1; // 返回基准值的最终索引
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
