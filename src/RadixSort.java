import java.util.Scanner;

public class RadixSort {

    static void radixSort(int[] arr,int l, int r, int digit) {
        int[] bucket = new int[r - l + 1];
        int radix = 10;

        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];

            for (int i = l; i <= r; i++) {
                count[getDigit(arr, i, d)]++;
            }

            for (int i = 1; i < radix; i++) {
                count[i] = count[i] + count[i-1];
            }

            for (int i = r;i >= l;i --) {
                bucket[count[getDigit(arr, i, d)]-- - 1] = arr[i];
            }

            System.arraycopy(bucket, 0, arr, l, r - l + 1);

        }


    }

    static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    static int maxBits(int[] arr) {
        int max = arr[0];

        for(int c: arr) {
            max = Math.max(max, c);
        }

        int res = 0;

        while(max > 0) {
            max /= 10;
            res++;
        }

        return res;
    }

    static int getDigit(int[] arr, int n, int digit) {
        int res = arr[n];
        for (int i = 1; i < digit; i++) {
            res /= 10;
        }
        return res%10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        radixSort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
