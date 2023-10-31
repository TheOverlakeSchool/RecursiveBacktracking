import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DiceRoll {
    public static void main(String[] args) {
        diceRoll(2);
    }

    public static void diceRoll(int dice) {
        diceRoll(dice, new Stack<>());
    }

    private static void diceRoll(int dice, Stack<Integer> chosen) {
        if (dice == 0) {
            System.out.println(chosen);
        } else {
            for (int i = 1; i <= 6; i++) {
                chosen.push(i);
                diceRoll(dice - 1, chosen);
                chosen.pop();
            }
        }
    }
}
