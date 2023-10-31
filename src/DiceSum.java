import java.util.Stack;

public class DiceSum {
    public static void main(String[] args) {
        diceSum(2,7);
    }

    private static void diceSum(int dice, int target) {
        diceSum(dice, target, new Stack<>(), 0);
    }

    private static void diceSum(int dice, int target, Stack<Integer> chosen, int sumThusFar) {
        if (dice == 0) {
            int sum = 0;
            for (int i : chosen) {
               sum += i;
            }
            if (sum == target) {
                System.out.println(chosen);
            }

        } else {
            for (int i = 1; i <= 6; i++) {
                if (sumThusFar) {
                    chosen.push(i);
                    diceSum(dice - 1, target, chosen, sumThusFar + i);
                    chosen.pop();
                }

            }
        }
    }
}
