import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Combinations {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		while (true) {
			System.out.print("Enter word: ");
			String word = console.next();
			System.out.print("How many characters? ");
			int count = console.nextInt();
			combinations(word, count);
		}
	}

	public static void combinations(String word, int count) {
		Set<String> combos = new TreeSet<>();
		// Great idea!
		// word = removeDupes(word);
		combinations(word, "", count, combos);
		System.out.println(combos);
	}

	private static void combinations(String available, String chosen, int count, Set<String> combos) {
		if (chosen.length() == count) {
			combos.add(chosen);
		} else {
			for (int i = 0; i < available.length(); i++) {
				String ch = available.substring(i, i+1);
				if (!chosen.contains(ch)) { // Unnecessary check if we removed dupes.
					String remaining = available.substring(0,i) + available.substring(i+1);
					combinations(remaining, chosen + ch, count, combos);
				}
			}
		}
	}

	private static String removeDupes(String word) {
		return word; // TODO
	}
}
