import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());

      if (n == 1) {
        System.out.println(0);
      } else if (n % 2 == 0) {
        System.out.println(new String("1").repeat(n));
      } else {
        System.out.println(new String("1") + new String("2").repeat(n - 2) + new String("1"));
      }
    }
  }
}