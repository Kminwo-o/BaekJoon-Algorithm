import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(bf.readLine());
		int num2 = Integer.parseInt(bf.readLine());
		
		System.out.println(num1 * (num2%10));
		System.out.println(num1 * (num2%100/10));
		System.out.println(num1 * (num2/100));
		System.out.println(num1*num2);
	}
}
