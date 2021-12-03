import java.util.Scanner;
import java.util.Stack;

public class Dice {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		while (true) {
			System.out.println("How many dice would you like to roll? (0 to exit)");
			int count = console.nextInt();
			if (count == 0) {
				break;
			}
			System.out.println("What is your target sum?");
			int sum = console.nextInt();
			diceSum(count, sum);
		}
	}

//	public static void diceRolls(int count) {
//		Stack<Integer> chosen = new Stack<>();
//		diceRolls(count, chosen);
//	}
//
//	private static void diceRolls(int available, Stack<Integer> chosen) {
//		if (available == 0) {
//			System.out.println(chosen);
//		} else {
//			for (int i = 1; i <= 6; i++) {
//				chosen.push(i); // choose
//				diceRolls(available - 1, chosen); // explore
//				chosen.pop(); // unchoose
//			}
//		}
//	}

	public static void diceSum(int count, int sum) {
		Stack<Integer> chosen = new Stack<>();
		diceSum(count, chosen, sum, 0);
	}

	private static void diceSum(int available, Stack<Integer> chosen, int sum, int runningTotal) {
		if (available == 0) {
			if (runningTotal == sum) {
				System.out.println(chosen);
			}
		} else if (runningTotal + available <= sum && runningTotal + available * 6 >= sum) {
			for (int i = 1; i <= 6; i++) {
				chosen.push(i); // choose
				diceSum(available - 1, chosen, sum, runningTotal + i); // explore
				chosen.pop(); // unchoose
			}
		}
	}

	private static int sum(Stack<Integer> chosen) {
		int sum = 0;
		Stack<Integer> temp = new Stack<>();
		while (!chosen.isEmpty()) {
			int value = chosen.pop();
			sum += value;
			temp.push(value);
		}

		while(!temp.isEmpty()) {
			chosen.push(temp.pop());
		}

		return sum;
	}
}
