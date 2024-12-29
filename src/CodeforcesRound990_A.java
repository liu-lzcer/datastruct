import java.util.Scanner;

public class CodeforcesRound990_A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int k = 0;k < n;k ++) {
            int m = sc.nextInt();
            int[][] arr = new int[2][m];
            for(int q = 0;q < 2;q++) {
                for(int w = 0;w < m;w++) {
                    arr[q][w] = sc.nextInt();
                }
            }
            int sum = getSum(arr, m);
            System.out.println(sum);
        }
    }

    private static int getSum(int[][] arr, int m) {
        int  sum = arr[0][0] + arr[1][0], pov = 0;

        for(int i = 1; i < m; i ++) {
            if(isBest(arr, i, pov)) {
                sum -= Math.min(arr[0][pov], arr[1][pov]);
                sum += arr[0][i] + arr[1][i];

                pov = i;

            } else {
                sum += Math.max(arr[0][i], arr[1][i]);
            }
        }
        return sum;
    }
    private static boolean isBest(int[][] arr, int i, int pov) {
        if(arr[0][pov] + arr[1][pov] + Math.max(arr[0][i], arr[1][i]) < arr[0][i] + arr[1][i] + Math.max(arr[0][pov], arr[1][pov])) {
            return true;
        }
        return false;
    }
}
