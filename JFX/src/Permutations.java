import java.util.*;

public class Permutations {

	public static ArrayList<ArrayList<Object>> permutations(ArrayList<Object> a) {

		ArrayList<ArrayList<Object>> perms = new ArrayList<ArrayList<Object>>();

		if (a.isEmpty()) {

			ArrayList<Object> onePerm = new ArrayList<Object>();

			perms.add(onePerm);

			return perms;

		}

		for (Object oneElem : a) { // take an element from the list

			ArrayList<Object> b = (ArrayList<Object>) (a.clone());

			b.remove(oneElem);

			// construct all permutations of the list without that element

			ArrayList<ArrayList<Object>> perms2 = permutations(b);

			// add the element that you took out back to the list

			for (ArrayList<Object> onePerm : perms2) {

				onePerm.add(oneElem);

				perms.add(onePerm);

			}

		}

		return perms;

	}

	public static void main(String[] args) {

		ArrayList<Object> a = new ArrayList<Object>();

		a.add("a");
		a.add("b");
		a.add("c");

		// query for all permutations of a

		ArrayList<ArrayList<Object>> perms = permutations(a);

		for (ArrayList<Object> onePerm : perms) {

			for (Object e : onePerm)
				// print all permutations

				System.out.print(e);

			System.out.println();

		}

	}

}
