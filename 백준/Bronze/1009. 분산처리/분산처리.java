import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int a, b;

        for (int i = 0; i < T; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            int result = 1;

            for(int j = 0; j < b; j++) {
                result = (result*a) % 10;
                }
                if (result == 0) result = 10;
                System.out.println(result);

            }
        sc.close();
        }

    }
