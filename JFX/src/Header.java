import java.util.Scanner;

public class Header {

	public static void head(int n, int m) {
		String str;
		if (n == 0) {
			// System.out.println(str);
		}
		if (n % 2 == 0) {
			for (int i = 0; i < m; i++) {
				System.out.print("#");
			}
		}
		if (n % 2 != 0) {
			for (int i = 0; i < m; i++) {
				if (i % 2 == 0)
					System.out.print("#");
				else if (i % 3 == 0)
					System.out.print("O");
				else
					System.out.print("*");
			}
		}
		// return head(str.substring(1)) + str.charAt(0);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int str1 = input.nextInt();
		int str2 = input.nextInt();
		// head(str1, str2);
		// System.out.println(str);
		for (int i = 1; i <= str1; i++) {
			nPrintln(str2, i);
			System.out.println();
		}
	}

	public static void nPrintln(int m, int times) {
		int count = 0;
		String m1 = "#";
		if (times % 2 == 0)
			m1 = "#";
		if (times % 2 != 0)
			if ((times / 2) % 2 == 0)
				m1 = "*";
			else
				m1 = "O";
		if (times >= 1) {
			for (int i = 0; i < m; i++) {
				System.out.print(m1);
				count++;
				// if(count > 3)
				// count = 0;
				if (times % 2 != 0) {
					if ((times / 2) % 2 == 0) {
						if ((count / 2) % 2 == 0)
							m1 = "#";
						if (count % 2 == 0)
							m1 = "O";
						if (count == 3)
							m1 = "*";
						if (count == 4)
							m1 = "#";
						if (count == 5)
							m1 = "O";
					} else {
						if ((count / 2) % 2 == 0)
							m1 = "#";
						if (count % 2 == 0)
							m1 = "*";
						if (count == 3)
							m1 = "O";
						if (count == 4)
							m1 = "#";
						if (count == 5)
							m1 = "*";
					}
				}
			}
			// nPrintln(message, times-1);
		}
	}

}
