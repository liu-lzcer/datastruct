import java.util.Scanner;

public class SmallNumber {
    static int progress(int[] a, int l, int r) {
        if(l == r)
            return 0;

        int mid = l + ((r - l) >> 1);

        return progress(a, l, mid) + progress(a, mid + 1, r) + merge(a, l, r);
    }

    static int merge(int[] a, int l, int r) {

        int[] help = new int[r-l+1];
        int mid = l + ((r - l) >> 1);

        int i = 0;
        int p1 = l;
        int res = 0;
        int p2 = mid + 1;

        while(p1 <= mid && p2 <= r) {
            res += a[p1] < a[p2] ? (r - p2 + 1) * a[p1] : 0;
            help[i++] = a[p1] < a[p2] ? a[p1++] : a[p2++];
        }
        while(p1 <= mid) {
            help[i++] = a[p1++];
        }
        while(p2 <= r) {
            help[i++] = a[p2++];
        }

        System.arraycopy(help, 0, a, l, help.length);

        return  res;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(progress(arr, 0, n-1));

    }
}
