import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class NOIP2009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        m = (int)(m*1.5);

        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new int[]{sc.nextInt(), sc.nextInt()});
        }
        arr.sort((a ,b) -> {
           if(a[1] != b[1]) return a[1] - b[1];
           else return a[0] - b[0];
        });

        int rank = arr.get(m)[1];
        
    }
}
