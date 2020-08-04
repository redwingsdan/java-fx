import java.util.Scanner;

public class Reverse {

	public static String reverse(String str) {
		if ((null == str) || (str.length() <= 1)) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str1 = input.next();
		String str = reverse(str1);
		System.out.println(str);
	}
}
