import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String S = br.readLine();
    StringBuilder sb = new StringBuilder(br.readLine());

    while (S.length() < sb.length()) {
      if (sb.charAt(sb.length() - 1) == 'A') {
        sb.deleteCharAt(sb.length() - 1);
      } else {
        sb.deleteCharAt(sb.length() - 1);
        sb.reverse();
      }
    }

    if (sb.toString().equals(S)) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
}