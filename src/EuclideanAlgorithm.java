import java.util.Scanner;
public class EuclideanAlgorithm {

    static int Gcd(int a, int b) {
        if(a == b)
            return a;
        if(a > b)
            return Gcd(a-b, b);
        else
            return Gcd(a, b-a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(Gcd(a, b));

    }
}
